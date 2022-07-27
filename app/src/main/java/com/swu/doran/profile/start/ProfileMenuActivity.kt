package com.swu.doran.profile.start

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.swu.doran.profile.edit.ProfileEditActivity


open class ProfileMenuActivity : AppCompatActivity() {

    lateinit var edit_profile: TextView
    public lateinit var add_profile: TextView
    lateinit var recyclerv: RecyclerView
    lateinit var userData: ProfileData
    lateinit var userAdapter: ProfileAdapter
    lateinit var userList: ArrayList<ProfileData>


    var storage: FirebaseStorage = FirebaseStorage.getInstance()
    var storageRef: StorageReference = storage.reference //뽑아오는 스토리지


    //realtime
    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    var profile_name = firebaseDatabase.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.swu.doran.R.layout.profile_start)




        add_profile = findViewById(com.swu.doran.R.id.add_profile)
        edit_profile = findViewById(com.swu.doran.R.id.edit_profile)

        recyclerv = findViewById(com.swu.doran.R.id.profile_rv)

        userList = ArrayList()
        userAdapter = ProfileAdapter(this, userList)
        recyclerv.adapter = userAdapter

        val gridLayoutManager = GridLayoutManager(applicationContext, 3)
        recyclerv.layoutManager = gridLayoutManager
        recyclerv.setHasFixedSize(true)

        // val icon = BitmapFactory.decodeResource(resources, R.drawable.user)


        user = FirebaseAuth.getInstance().currentUser
        assert(user != null)
        uid = user!!.uid

        //고유키와 함께 저장하기 위한 장치
        val key = accountReference.push().key

        val profileRef: DatabaseReference = accountReference.child(uid!!).child("profile")


        var default = 0


        /*프로필 추가 이벤트*/
        add_profile.setOnClickListener {

            profileRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataSnapshot in snapshot.children) {
                        /*해당 프로필이 존재한다면*/
//                        Log.d("snapshot: ", snapshot.toString())
//                        Log.d("dataSnapshot.key: ", dataSnapshot.key.toString())

                        val arr = dataSnapshot.key.toString().split("r")

                        Log.d("arr[1] : ", arr[1])

                        //작거나 같을 때 증가
                        if (default <= arr[1].toInt()) {
                            default++
                        }


                    }
                    val resources: Resources = resources

                    val default_img = Uri.parse(
                        ContentResolver.SCHEME_ANDROID_RESOURCE
                                + "://" + resources.getResourcePackageName(com.swu.doran.R.drawable.mom01)
                                + '/' + resources.getResourceTypeName(com.swu.doran.R.drawable.mom01)
                                + '/' + resources.getResourceEntryName(com.swu.doran.R.drawable.mom01)
                    )

                    userData = ProfileData(
                        key,
                        default_img.toString(),
                        "User$default",
                        "yy.mm.dd",
                        "LunarOrSolar"
                    )
                    profileRef.child(userData.profile_name!!).setValue(userData)


                }


                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext, "프로필 조회 실패", Toast.LENGTH_SHORT).show()
                }

            })


        }


        /*프로필 편집 이벤트*/
        edit_profile.setOnClickListener {
            startActivity(Intent(this, ProfileEditActivity::class.java))
        }


        /*
        lateinit var inflater: LayoutInflater
        lateinit var view: View
        lateinit var addProfile: TextView
        lateinit var profile_rv:RecyclerView
        lateinit var EditProfile:TextView
        lateinit var mContext:Context
        var list= ArrayList<ProfileData>()
        var clickcount=-1
        val adapter= ProfileAdapter(this,list)




            list = ArrayList()
            //addProfile=findViewById(R.id.addProfile)
           // profile_rv=findViewById(R.id.profile_rv)
           // EditProfile=findViewById(R.id.EditProfile)

            profile_rv.adapter=adapter
            val layout=LinearLayoutManager(this)
            profile_rv.layoutManager=layout
            profile_rv.setHasFixedSize(true)



            //프로필 추가 리스너
            addProfile.setOnClickListener {it->
                clickcount += 1;
                if(clickcount==1)
                {
                    //first time clicked to do this
                    Toast.makeText(applicationContext,"Button clicked first time!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    //check how many times clicked and so on
                    Toast.makeText(applicationContext, "Button clicked count is$clickcount", Toast.LENGTH_LONG).show();
                }
                startActivity(Intent(this, ProfileEditActivity::class.java))

            }
            //프로필 수정 리스너
            EditProfile.setOnClickListener{
                startActivity(Intent(this,ProfileSelectActivity::class.java))

            }
        }
        */


        //항상 프로필 읽어오기
        ReadProfile()

    }

    fun ReadProfile() {
        accountReference.child(uid!!).child("profile")
            .addValueEventListener(object : ValueEventListener {

                @SuppressLint("NotifyDataSetChanged")
                override fun onDataChange(snapshot: DataSnapshot) {
                    userList.clear()

                    //Log.d("TAG", String.valueOf(snapshot));
                    for (dataSnapshot in snapshot.children) {
                        //val data_name = dataSnapshot.key
                        val read_p: ProfileData? = dataSnapshot.getValue(ProfileData::class.java)
                        //read_p?.key = data_name

                        userList.add(read_p!!)
                        // Log.d("readPf_snap", data_name.toString())
//                        if (!read_p.cl) {
//                            gDialog.add(read_g)
//                        }
                    }
                    userAdapter.notifyDataSetChanged()
                    recyclerv.adapter = userAdapter
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext, "불러오기 실패", Toast.LENGTH_SHORT).show()
                }
            })


    }
}