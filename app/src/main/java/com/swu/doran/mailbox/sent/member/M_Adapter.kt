package com.swu.doran.mailbox.sent.member

//class M_Adapter(private val context: Context) : RecyclerView.Adapter<M_Adapter.ViewHolder>() {

//    var datas = mutableListOf<M_Data>()
//
//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        private val img: ImageView = itemView.findViewById(R.id.img)
//        private val name: TextView = itemView.findViewById(R.id.name)
//        private val accumulated: TextView =itemView.findViewById(R.id.accumulated)
//
//        fun bind(item: M_Data) {
//            Glide.with(itemView).load(item.img).into(img)
//            name.text= item.name
//            accumulated.text= item.accumulated.toString()
//
//            //멤버 아이템 클릭 리스너
//            //멤버데이터에서 이미지,이름,누적개수,뱃지 추출
//            itemView.setOnClickListener {
//                Intent(context, L_Activity_X::class.java).apply {
//                    putExtra("data", item)
//                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                }.run {
//                    context.startActivity(this)
//                }
//                Intent(context, L_ContentsActivity::class.java).apply {
//                    putExtra("data", item)
//                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                }.run {
//
//                }
//            }
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): M_Adapter.ViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.received_member_item, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: M_Adapter.ViewHolder, position: Int) {
//        holder.bind(datas[position])
//    }
//
//    override fun getItemCount(): Int = datas.size
//}