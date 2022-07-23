package com.swu.doran


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.swu.doran.calendar.MainCalendarActivity
import com.swu.doran.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private var toolbar: Toolbar? = null

    private lateinit var binding: ActivityMainBinding
    lateinit var bottomSheet: CardView


    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


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
                else if(-1<=slideOffset&&slideOffset<0){
                    binding.bottomSheet.radius=cornerRadius
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

        //toolbardxf
        toolbar = findViewById(R.id.toolbar)
        toolbar?.inflateMenu(R.menu.toolbar)


        toolbar?.setNavigationOnClickListener { this.onBackPressed() }

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
            } else {

                Toast.makeText(this, "갤러리 클릭", Toast.LENGTH_SHORT).show()
            }
            true
        }


    }


}


