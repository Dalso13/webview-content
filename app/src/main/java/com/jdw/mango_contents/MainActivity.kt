package com.jdw.mango_contents

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.addAll(
            mutableListOf<ContentsModel>(
                ContentsModel(
                    "https://www.teamblind.com/kr/post/%EA%B2%B0%ED%98%BC%ED%95%98%EB%A9%B4%EC%84%9C-%EC%95%84%EB%B6%80%EC%A7%80-%EC%88%A0-%EC%B0%BD%EA%B3%A0-%ED%84%B8%EB%8B%A4%EA%B0%80-%EC%B2%A8%EB%B3%B4%EB%8A%94-%EC%88%A0%EC%9D%B4-%EC%9E%88%EB%88%88%EB%8D%B0-%EC%9A%94%EA%B3%A0-%EB%A8%B9%EC%96%B4%EB%8F%84-%EB%90%98%EA%B2%A0%EC%A3%A0-CbdAHrmu",
                    "https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/531/9aa1c11796d813ad9eae2daa9b94f888_res.jpeg",
                    "결혼하면서 아부지 술 창고 털다가 첨보는 술이 있눈데 요고 먹어도 되겠죠..?"
                ),
                ContentsModel(
                    "https://www.teamblind.com/kr/post/%EB%B2%99%EA%B1%B0%EC%A7%80%EB%AA%A8%EC%9E%90-%EC%A2%80-%EC%95%88%EC%8D%BC%EC%9C%BC%EB%A9%B4-%EC%A2%8B%EA%B2%A0%EB%8B%A4-aYz2VVB5",
                    "https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/168/0c174c2cae4625554de5d22da110e2ee_res.jpeg",
                    "벙거지모자 좀 안썼으면 좋겠다"
                ),
                ContentsModel(
                    "https://www.teamblind.com/kr/post/%EC%95%84%EB%82%9C%ED%8B%B0-%EC%95%B3-%EB%B6%80%EC%82%B0-%EC%BD%94%EB%B8%8C-%EC%88%99%EB%B0%95%EA%B6%8C-%EC%96%91%EB%8F%84-4244-YEu40R0Z",
                    "https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/698/a71905c5a1a92d1ca014e435401927fc_res.jpeg",
                    "아난티 앳 부산 코브 숙박권 양도 (4/2~4/4)"
                ),
                ContentsModel(
                    "https://www.teamblind.com/kr/post/%EC%95%84%EC%9D%B4-%EC%A0%84%EC%A7%91-%EB%8B%B9%EA%B7%BC%ED%96%88%EB%8A%94%EB%8D%B0-wAHP5J5y",
                    "https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/73/41b45888b9f5fb81d612ccda16768d09_res.jpeg",
                    "아이 전집 당근했는데"
                )
            )
        )

        val rv = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(items,baseContext)
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(this,2)




    }
}