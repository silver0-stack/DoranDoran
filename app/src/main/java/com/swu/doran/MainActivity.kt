package com.swu.doran


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.swu.doran.calendar.MainCalendarActivity
import com.swu.doran.databinding.ActivityMainBinding
import de.hdodenhof.circleimageview.CircleImageView


class MainActivity : AppCompatActivity() {


    private var toolbar: Toolbar? = null

    private lateinit var binding: ActivityMainBinding
    lateinit var bottomSheet: CardView

    //네비게이션 드로우
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout

    //Toolbar toolbar;
    lateinit var barDrawerToggle: ActionBarDrawerToggle


    var uid: String? = null
    var user: FirebaseUser? = null
    var firebaseDatabase = FirebaseDatabase.getInstance()
    var accountReference = firebaseDatabase.getReference("Account")
    lateinit var profileRef: DatabaseReference


    lateinit var user_img: CircleImageView
    lateinit var user_name: TextView
    lateinit var user_birth: TextView

    lateinit var view: View
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //toolbardxf
        toolbar = findViewById(R.id.toolbar)
        toolbar?.inflateMenu(R.menu.toolbar)


        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav)
        navigationView.itemIconTintList = null

        //Drawer 토글버튼 생성
        barDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        //삼선아이콘 모양으로 보이기, 동기맞춤
        barDrawerToggle.syncState()
        //삼선 아이콘 화살표 아이콘 자동 변환
        drawerLayout.addDrawerListener(barDrawerToggle)


        //카드뷰
        bottomSheet = findViewById(R.id.bottom_sheet)

        // 현재 접힌 상태에서의 BottomSheet 귀퉁이의 둥글기 저장
        val cornerRadius = bottomSheet.radius

        //BottomSheetBehavior 를 얻어옴
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.saveFlags = BottomSheetBehavior.SAVE_ALL

        bottomSheetBehavior.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // 상태가 변함에 따라서 할일들을 적어줍니다.
                if (newState == STATE_EXPANDED) {
                    //fragment의 추가,교체,제거를 위한 Transaction API
                    val fragmentManager = supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val cal_frag = MainCalendarActivity()

                    fragmentTransaction.add(R.id.BSD_fragment, cal_frag)
                    fragmentTransaction.commit()
                }
            }

            override fun onSlide(bottomSheetView: View, slideOffset: Float) {
                // slideOffset 펼쳐짐: 0.0 ~ 1.0
                if (slideOffset >= 0) {
                    // 둥글기는 펼칠수록 줄어들도록
                    binding.bottomSheet.radius = cornerRadius - (cornerRadius * slideOffset)
                    // 화살표는 완전히 펼치면 180도 돌아가게
                    binding.guideline1.rotation = (1 - slideOffset) * 180F
                    // 글자는 조금더 빨리 사라지도록
                    binding.guideline2.alpha = 1 - slideOffset * 2.3F
                    // 내용의 투명도도 같이 조절...
                    //binding.bottomSheet.alpha = (slideOffset * 2F).coerceAtMost(1F)
                }
                //slideOffset 접힘 : -1.0 ~ 0.0
                else if (-1 <= slideOffset && slideOffset < 0) {
                    binding.bottomSheet.radius = cornerRadius
                }
            }
        })


//        bottomSheet = bottomSheetDialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
//        val bsb = BottomSheetBehavior.from(findViewById<View>(R.id.design_bottom_sheet))
//        val layoutParams: ViewGroup.LayoutParams = bottomSheet!!.layoutParams;
//        //     layoutParams.height = getBottomSheetDialogDefaultHeight();
//        bottomSheet!!.layoutParams = layoutParams;
//
//        //bottom sheet
//        val cal_v = layoutInflater.inflate(R.layout.calendar_bottom_sheet, null)
//        bsd = BottomSheetDialog(this)


//        val behavior = BottomSheetBehavior.from(bsd.behavior)
        //접혀있는 상태
        ///behavior.state = BottomSheetBehavior.STATE_COLLAPSED;


        //BottomSheetBehavior 로 설정된 뷰가 파괴되고 다시 생성되는 경우 유지할 속성
        // BottomSheetBehavior.SAVE_ALL.also { bsb.saveFlags = it }


//        //BottomSheetBehavior 콜백 수신
//        bsb.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                // slide
//            }
//
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                // state changed
//            }
//        })
        user = FirebaseAuth.getInstance().currentUser
        uid = user?.uid

        //네비게이션뷰의 아이템 클릭시
        profileRef = accountReference.child(uid!!).child("profile")


        val intent = intent
        val profile_number = intent.getIntExtra("profile_number", 0)

       val nav_header_view= navigationView.getHeaderView(0);

//        val inflater: LayoutInflater = layoutInflater
//        view = inflater.inflate(R.layout.drawer_header, null, false)

        //네비게이션 프로필 이름, 이미지 가져오기
        profileRef.child("User$profile_number")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val name = snapshot.child("profile_name").getValue(String::class.java)
                    val img_uri = snapshot.child("profile_img").getValue(String::class.java)
                    val birth = snapshot.child("profile_birth").getValue(String::class.java)

                    Log.d("drawer_name: ", name.toString())
                    Log.d("drawer_img_uri: ", img_uri.toString())
                    Log.d("drawer_birth: ", birth.toString())

                    user_img = nav_header_view.findViewById(R.id.user_img)
                    Glide.with(navigationView)
                        .load(img_uri)
                        .into(user_img)

                    user_name = nav_header_view.findViewById(R.id.user_name)
                    user_name.text = name + "님"

                    user_birth = nav_header_view.findViewById(R.id.user_birth)
                    user_birth.text = birth
                }

                override fun onCancelled(error: DatabaseError) {}
            })
        //네비게이션뷰의 아이템 클릭시
        navigationView.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_profile -> {
                    Toast.makeText(this, "프로필 클릭", Toast.LENGTH_SHORT).show()
//                    val personalIntent = Intent(this, ProfileEditActivity::class.java)
//                    startActivity(personalIntent)
//                    finish()
                }
                R.id.menu_talk -> {
                    Toast.makeText(this, "가족톡 클릭", Toast.LENGTH_SHORT).show()
//                    val personalIntent = Intent(this, MainActivity::class.java)
//                    startActivity(personalIntent)
//                    finish()
                }
                R.id.menu_mailbox -> {
                    Toast.makeText(this, "우체통 클릭", Toast.LENGTH_SHORT).show()
//                    val personalIntent = Intent(this, MainActivity::class.java)
//                    startActivity(personalIntent)
//                    finish()
                }
                R.id.menu_rule -> {
                    Toast.makeText(this, "가족 규칙 클릭", Toast.LENGTH_SHORT).show()
//                    val personalIntent = Intent(this, MainActivity::class.java)
//                    startActivity(personalIntent)
//                    finish()
                }
                R.id.menu_set -> {
                    Toast.makeText(this, "설정 클릭", Toast.LENGTH_SHORT).show()
//                    val personalIntent = Intent(this, MainActivity::class.java)
//                    startActivity(personalIntent)
//                    finish()
                }
            }
            drawerLayout.closeDrawer(navigationView)
            false
        }

        //  toolbar?.setNavigationOnClickListener { this.onBackPressed() }

//        backgroundLayout.setOnClickListener(object : OnClickListener() {
//            fun onClick(v: View?) {
//                when (bottomSheetBehavior.getState()) {
//                    BottomSheetBehavior.STATE_COLLAPSED -> bottomSheetBehavior.setState(
//                        BottomSheetBehavior.STATE_EXPANDED
//                    )
//                    BottomSheetBehavior.STATE_EXPANDED -> bottomSheetBehavior.setState(
//                        BottomSheetBehavior.STATE_COLLAPSED
//                    )
//                }
//            }
//        })

        toolbar?.setOnMenuItemClickListener { item: MenuItem ->
            val id = item.itemId
            if (id == R.id.noti) {
                Toast.makeText(this, "알림 클릭", Toast.LENGTH_SHORT).show()
            }
            true
        }


    }


}


