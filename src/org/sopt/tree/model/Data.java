package org.sopt.tree.model;

import org.sopt.tree.tree.base.Element;

import java.util.Random;

/**
 * Created by callisto on 9/23/15.
 */
public class Data extends Element {

    // 비교를 위해 임의의 id 값을 배정하도록 하였습니다.
    private static final int ID_LIMITATION = 50;
    private static Random random = new Random();


    // 커스텀 데이터를 구성하는 속성입니다. id 속성의 경우, 루트 노드에 대해서는 0을 할당하며 이외의 노드는 임의로 할당합니다.
    public int id;

    public String title;
    public String content;

    public Data() { this.id = 0; }
    public Data(String title, String content) {

        this.id = random.nextInt(ID_LIMITATION) + 1;
        this.title = title;
        this.content = content;
    }

    public Data(int id, String title, String content) {

        this.id = id;
        this.title = title;
        this.content = content;
    }

    /**
     *
     * @return
     */
    @Override
    public String key() { return String.valueOf(id); }

    /**
     *
     * 두 개체를 비교하는 메서드를 오버라이딩합니다.
     *
     * @param obj 비교할 대상을 의미합니다.
     * @return 비교 결과를 반환합니다. 자기 자신을 기준으로 비교하는 코드를 작성합니다.
     */
    @Override
    public int compareTo(Object obj) {

        if (!(obj instanceof Data))
            throw new UnsupportedOperationException();

        Data data = (Data) obj;

        if (this.id == data.id) return CRITERION_EQ;
        if (this.id >  data.id) return CRITERION_GT;
        if (this.id <  data.id) return CRITERION_LT;

        throw new IllegalStateException();
    }

    /**
     *
     * 두 개체를 교환합니다.
     * 엘레멘트 사이의 연결 고리는 복사 대상이 아니므로, Deep Copy 대신 필요한 부분만을 변경할 수 있도록 재정의 합니다.
     *
     * @param obj 교환 대상
     */
    @Override
    public void exchange(Object obj) {

        if (!(obj instanceof Data))
            throw new UnsupportedOperationException();

        Data data = (Data) obj;
        Data temp = new Data();

        temp.id = this.id;
        temp.title = this.title;
        temp.content = this.content;

        this.id = data.id;
        this.title = data.title;
        this.content = data.content;

        data.id = temp.id;
        data.title = temp.title;
        data.content = temp.content;
    }

    /**
     *
     * 데이터 출력을 위해 재정의합니다.
     *
     * @return 식별을 위한 데이터
     */
    @Override
    public String toString() { return "ID : " + id + " | Title : " + title + " | Content : " + content; }


    /**
     *
     * 두 개체가 동일한 지 id를 기준으로 비교합니다.
     *
     * @param obj 비교 대상
     * @return 동일 여부
     */
    @Override
    public boolean equals(Object obj) {

        return obj instanceof Data && this.id == ((Data) obj).id;
    }
}
