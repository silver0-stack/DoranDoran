package com.swu.doran.profile.add

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.swu.doran.R

class Profile_select_emoji : AppCompatActivity(), View.OnClickListener {
    lateinit var gf01: ToggleButton
    lateinit var gf02: ToggleButton

    lateinit var gm01: ToggleButton
    lateinit var gm02: ToggleButton

    lateinit var dad01: ToggleButton
    lateinit var dad02: ToggleButton

    lateinit var mom01: ToggleButton
    lateinit var mom02: ToggleButton

    lateinit var boy_5s_01: ToggleButton
    lateinit var boy_5s_02: ToggleButton

    lateinit var boy_10s_01: ToggleButton
    lateinit var boy_10s_02: ToggleButton

    lateinit var boy_20s_01: ToggleButton
    lateinit var boy_20s_02: ToggleButton

    lateinit var boy_30s_01: ToggleButton
    lateinit var boy_30s_02: ToggleButton

    lateinit var girl_5s_01: ToggleButton
    lateinit var girl_5s_02: ToggleButton

    lateinit var girl_10s_01: ToggleButton
    lateinit var girl_10s_02: ToggleButton

    lateinit var girl_20s_01: ToggleButton
    lateinit var girl_20s_02: ToggleButton

    lateinit var girl_30s_01: ToggleButton
    lateinit var girl_30s_02: ToggleButton

    lateinit var put_intent: Intent

    lateinit var complete: TextView


    var storage: FirebaseStorage = FirebaseStorage.getInstance()
    var storageRef: StorageReference = storage.reference //뽑아오는 스토리지

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_select_emoji)

        complete = findViewById(R.id.complete)
        gf01 = findViewById(R.id.gf01)
        gf02 = findViewById(R.id.gf02)
        gm01 = findViewById(R.id.gm01)
        gm02 = findViewById(R.id.gm02)
        mom01 = findViewById(R.id.mom01)
        mom02 = findViewById(R.id.mom02)
        dad01 = findViewById(R.id.dad01)
        dad02 = findViewById(R.id.dad02)
        boy_5s_01 = findViewById(R.id.boy_5s_01)
        boy_5s_02 = findViewById(R.id.boy_5s_02)
        boy_10s_01 = findViewById(R.id.boy_10s_01)
        boy_10s_02 = findViewById(R.id.boy_10s_02)
        boy_20s_01 = findViewById(R.id.boy_20s_01)
        boy_20s_02 = findViewById(R.id.boy_20s_02)
        boy_30s_01 = findViewById(R.id.boy_30s_01)
        boy_30s_02 = findViewById(R.id.boy_30s_02)
        girl_5s_01 = findViewById(R.id.girl_5s_01)
        girl_5s_02 = findViewById(R.id.girl_5s_02)
        girl_10s_01 = findViewById(R.id.girl_10s_01)
        girl_10s_02 = findViewById(R.id.girl_10s_02)
        girl_20s_01 = findViewById(R.id.girl_20s_01)
        girl_20s_02 = findViewById(R.id.girl_20s_02)
        girl_30s_01 = findViewById(R.id.girl_30s_01)
        girl_30s_02 = findViewById(R.id.girl_30s_02)




        put_intent = Intent(this, Profile_emoji::class.java)
        //
        gf01.setOnClickListener(this)
        gf02.setOnClickListener(this)
        gm01.setOnClickListener(this)
        gm02.setOnClickListener(this)
        mom01.setOnClickListener(this)
        mom02.setOnClickListener(this)
        dad01.setOnClickListener(this)
        dad02.setOnClickListener(this)
        boy_5s_01.setOnClickListener(this)
        boy_5s_02.setOnClickListener(this)
        boy_10s_01.setOnClickListener(this)
        boy_10s_02.setOnClickListener(this)
        boy_20s_01.setOnClickListener(this)
        boy_20s_02.setOnClickListener(this)
        boy_30s_01.setOnClickListener(this)
        boy_30s_02.setOnClickListener(this)
        girl_5s_01.setOnClickListener(this)
        girl_5s_02.setOnClickListener(this)
        girl_10s_01.setOnClickListener(this)
        girl_10s_02.setOnClickListener(this)
        girl_20s_01.setOnClickListener(this)
        girl_20s_02.setOnClickListener(this)
        girl_30s_01.setOnClickListener(this)
        girl_30s_02.setOnClickListener(this)

        complete.setOnClickListener {
            startActivity(put_intent)
        }

    }


    fun back(view: View?) {
        super.onBackPressed()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v) {
                gf01 -> if (gf01.isChecked) {
                    gf01.isChecked = true
                    Toast.makeText(applicationContext, "gf01 클릭", Toast.LENGTH_SHORT).show()

                    Log.d("uri 로그찍기", "0")

//                    val uri = Uri.parse("android.resource://com.swu.doran/drawable/grandfather01")
//                    val stream: InputStream? = contentResolver.openInputStream(uri)
//                    Log.d("uri_put", "" + stream)
//                    put_intent.putExtra("profile_img", stream.toString())


                    storageRef
                        .child("profileImg/grandfather01.png")
                        .downloadUrl
                        .addOnSuccessListener (object :OnSuccessListener<Uri> {
                            override fun onSuccess(p0: Uri?) {
                                //성공시
                                Log.d("uri 로그찍기", "1")
                                val uri_ = p0.toString()
                                Log.d("uri_put", "" + uri_)
                                put_intent.putExtra("profile_img", uri_)
                            }
                        }


                        )

                        .addOnFailureListener(object : OnFailureListener {
                            override fun onFailure(p0: Exception) {
                                Toast.makeText(applicationContext, "이미지 업로드 실패", Toast.LENGTH_SHORT).show()
                                p0.printStackTrace()
                            }
                        }
                        )

                    Log.d("uri 로그찍기", "2")
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    gf01.isChecked = false
                }


                gf02 -> if (gf02.isChecked) {
                    gf02.isChecked = true
                    Toast.makeText(applicationContext, "gf02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/grandfather02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }


                    gf01.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    gf02.isChecked = false
                }

                gm01 -> if (gm01.isChecked) {
                    gm01.isChecked = true
                    Toast.makeText(applicationContext, "gm01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/grandmather01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }


                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    gm01.isChecked = false
                }


                gm02 -> if (gm02.isChecked) {
                    gm02.isChecked = true
                    Toast.makeText(applicationContext, "gm02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/grandmather02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
//                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    gm02.isChecked = false
                }


                mom01 -> if (mom01.isChecked) {
                    mom01.isChecked = true
                    Toast.makeText(applicationContext, "mom01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/mom01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    // mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    mom01.isChecked = false
                }

                mom02 -> if (mom02.isChecked) {
                    mom02.isChecked = true
                    Toast.makeText(applicationContext, "mom02  클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/mom02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
//                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    mom02.isChecked = false
                }

                dad01 -> if (dad01.isChecked) {
                    dad01.isChecked = true
                    Toast.makeText(applicationContext, "dad01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/dad01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
//                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    dad01.isChecked = false
                }

                dad02 -> if (dad02.isChecked) {
                    dad02.isChecked = true
                    Toast.makeText(applicationContext, "dad02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/dad02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
//                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    dad02.isChecked = false
                }

                boy_5s_01 -> if (boy_5s_01.isChecked) {
                    boy_5s_01.isChecked = true
                    Toast.makeText(applicationContext, "boy_5s_01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/5sboy01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
//                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    boy_5s_01.isChecked = false
                }

                boy_5s_02 -> if (boy_5s_02.isChecked) {
                    boy_5s_02.isChecked = true
                    Toast.makeText(applicationContext, "boy_5s_02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/5sboy02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
//                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    boy_5s_02.isChecked = false
                }

                boy_10s_01 -> if (boy_10s_01.isChecked) {
                    boy_10s_01.isChecked = true
                    Toast.makeText(applicationContext, "boy_10s_01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/10sboy01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
//                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    boy_10s_01.isChecked = false
                }

                boy_10s_02 -> if (boy_10s_02.isChecked) {
                    boy_10s_02.isChecked = true
                    Toast.makeText(applicationContext, "boy_10s_02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/10sboy02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
//                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    boy_10s_02.isChecked = false
                }

                boy_20s_01 -> if (boy_20s_01.isChecked) {
                    boy_20s_01.isChecked = true
                    Toast.makeText(applicationContext, "boy_20s_01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/20sboy01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
//                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    boy_20s_01.isChecked = false
                }

                boy_20s_02 -> if (boy_20s_02.isChecked) {
                    boy_20s_02.isChecked = true
                    Toast.makeText(applicationContext, " boy_20s_02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/20sboy02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
//                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    boy_20s_02.isChecked = false
                }

                boy_30s_01 -> if (boy_30s_01.isChecked) {
                    boy_30s_01.isChecked = true
                    Toast.makeText(applicationContext, "boy_30s_01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/30sboy01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
//                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    boy_30s_01.isChecked = false
                }

                boy_30s_02 -> if (boy_30s_02.isChecked) {
                    boy_30s_02.isChecked = true
                    Toast.makeText(applicationContext, "boy_30s_02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/30sboy02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
//                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    boy_30s_02.isChecked = false
                }

                girl_5s_01 -> if (girl_5s_01.isChecked) {
                    girl_5s_01.isChecked = true
                    Toast.makeText(applicationContext, " girl_5s_01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/5sgirl01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
//                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    girl_5s_01.isChecked = false
                }

                girl_5s_02 -> if (girl_5s_02.isChecked) {
                    girl_5s_02.isChecked = true
                    Toast.makeText(applicationContext, " girl_5s_02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/5sgirl02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
//                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    girl_5s_02.isChecked = false
                }

                girl_10s_01 -> if (girl_10s_01.isChecked) {
                    girl_10s_01.isChecked = true
                    Toast.makeText(applicationContext, "girl_10s_01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/10sgirl01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
//                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    girl_10s_01.isChecked = false
                }

                girl_10s_02 -> if (girl_10s_02.isChecked) {
                    girl_10s_02.isChecked = true
                    Toast.makeText(applicationContext, "girl_10s_02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/10sgirl02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
//                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    girl_10s_02.isChecked = false
                }

                girl_20s_01 -> if (girl_20s_01.isChecked) {
                    girl_20s_01.isChecked = true
                    Toast.makeText(applicationContext, "girl_20s_01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/20sgirl01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
//                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    girl_20s_01.isChecked = false
                }

                girl_20s_02 -> if (girl_20s_02.isChecked) {
                    girl_20s_02.isChecked = true
                    Toast.makeText(applicationContext, "girl_20s_02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/20sgirl02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
//                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    girl_20s_02.isChecked = false
                }

                girl_30s_01 -> if (girl_30s_01.isChecked) {
                    girl_30s_01.isChecked = true
                    Toast.makeText(applicationContext, "girl_30s_01 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/30sgirl01.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
//                    girl_30s_01.isChecked = false
                    girl_30s_02.isChecked = false
                } else {
                    girl_30s_01.isChecked = false
                }

                girl_30s_02 -> if (girl_30s_02.isChecked) {
                    girl_30s_02.isChecked = true
                    Toast.makeText(applicationContext, "girl_30s_02 클릭", Toast.LENGTH_SHORT).show()

                    storageRef.child("profileImg/30sgirl02.png").downloadUrl
                        .addOnSuccessListener { uri ->
                            put_intent.putExtra("profile_img", uri)

                        }.addOnFailureListener { err ->
                            err.printStackTrace()
                        }

                    gf01.isChecked = false
                    gf02.isChecked = false
                    gm01.isChecked = false
                    gm02.isChecked = false
                    mom01.isChecked = false
                    mom02.isChecked = false
                    dad01.isChecked = false
                    dad02.isChecked = false
                    boy_5s_01.isChecked = false
                    boy_5s_02.isChecked = false
                    boy_10s_01.isChecked = false
                    boy_10s_02.isChecked = false
                    boy_20s_01.isChecked = false
                    boy_20s_02.isChecked = false
                    boy_30s_01.isChecked = false
                    boy_30s_02.isChecked = false
                    girl_5s_01.isChecked = false
                    girl_5s_02.isChecked = false
                    girl_10s_01.isChecked = false
                    girl_10s_02.isChecked = false
                    girl_20s_01.isChecked = false
                    girl_20s_02.isChecked = false
                    girl_30s_01.isChecked = false
//                    girl_30s_02.isChecked = false
                } else {
                    girl_30s_02.isChecked = false
                }


            }
        }

    }
}