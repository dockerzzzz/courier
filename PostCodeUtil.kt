/**
 * 택배사별 코드를 가져오기 위한 enum 객체 취득 팩토리 클래스
 */
enum class CourierCompany {
    HANJIN,CJLOGISTICS,LOTTEGLOGIS
}

enum class CourierCompanyFactory(
    val courierCompany: CourierCompany,
    val postEnumClazz: Class<out IslandPostEnum>,
    val findEnumObjectByPostCode: (Int) -> IslandPostEnum
) {
    HANJIN(CourierCompany.HANJIN, HanJinIslandPostEnum::class.java, { postCode ->
        HanJinIslandPostEnum.values().firstOrNull {
            postCode in it.startPostCode..it.endPostCode
        } ?: HanJinIslandPostEnum.NONE
    }),
    CJLOGISTICS(CourierCompany.CJLOGISTICS, CJIslandPostEnum::class.java, { postCode ->
        CJIslandPostEnum.values().firstOrNull {
            postCode in it.startPostCode..it.endPostCode
        } ?: CJIslandPostEnum.NONE
    }),
    LOTTEGLOGIS(CourierCompany.LOTTEGLOGIS, LotteIslandPostEnum::class.java, { postCode ->
        LotteIslandPostEnum.values().firstOrNull {
            postCode in it.startPostCode..it.endPostCode
        } ?: LotteIslandPostEnum.NONE
    });

    companion object {
        fun getClazz(courierCompany: CourierCompany): IslandPostEnum? {
            return values().firstOrNull {
                it.courierCompany == courierCompany
            }?.postEnumClazz?.enumConstants?.first()
        }
    }
}

/**
 * 택배사 도서산간 코드 인터페이스
 */
interface IslandPostEnum {
    val courierCompanyName: String
    val areaName: String
    val startPostCode: Int
    val endPostCode: Int
    val isJeJu: Boolean
    val isIsland: Boolean
    var enumObject: (postCode: Int) -> IslandPostEnum
}

/**
 * 한진택배 도서산간 코드
 */
enum class HanJinIslandPostEnum(
    override val courierCompanyName: String,
    override val areaName: String,
    override val startPostCode: Int,
    override val endPostCode: Int,
    override val isJeJu: Boolean,
    override val isIsland: Boolean,
    override var enumObject: (postCode: Int) -> IslandPostEnum 
) : IslandPostEnum {
    JEJU("HANJIN", "제주도", 63000, 63644, true, true, { postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA01("HANJIN","인천 중구 섬지역",22386,22388,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA02("HANJIN","인천 강화 섬지역",23004,23010,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA03("HANJIN","인천 옹진 섬지역1",23100,23116,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA04("HANJIN","인천 옹진 섬지역2",23124,23136,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA05("HANJIN","충남 당진 섬지역",31708,31708,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA06("HANJIN","충남 태안 섬지역",32133,32133,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA07("HANJIN","충남 보령 섬지역",33411,33411,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA08("HANJIN","경북 울릉도 전지역",40200,40240,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA09("HANJIN","부산 강서구 섬지역",46768,46771,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA10("HANJIN","경남 사천 섬지역",52570,52571,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA11("HANJIN","경남 통영 섬지역1",53031,53033,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA12("HANJIN","경남 통영 섬지역2",53089,53104,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA13("HANJIN","경남 통영 섬지역3",54000,54000,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA14("HANJIN","전북 부안 섬지역",56347,56349,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA15("HANJIN","전남 영광 섬지역",57068,57069,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA16("HANJIN","전남 목포 섬지역",58760,58762,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA17("HANJIN","전남 신안 섬지역1",58800,58810,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA18("HANJIN","전남 신안 섬지역2",58816,58818,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA19("HANJIN","전남 신안 섬지역3",28826,28826,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA20("HANJIN","전남 신안 섬지역4",58828,58866,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA21("HANJIN","전남 진도 섬지역",58953,58958,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA22("HANJIN","전남 완도 섬지역1",59102,59103,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA23("HANJIN","전남 완도 섬지역2",59106,59106,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA24("HANJIN","전남 완도 섬지역3",59127,59127,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA25("HANJIN","전남 완도 섬지역4",59129,59129,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA26("HANJIN","전남 완도 섬지역5",59137,59166,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA27("HANJIN","전남 여수시 섬지역1",59650,59650,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA28("HANJIN","전남 여수시 섬지역2",59766,59766,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    AREA29("HANJIN","전남 여수시 섬지역3",59781,59790,false,true,{ postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) }),
    NONE("HANJIN", "NONE", 0, 0, false, false, { postCode -> CourierCompanyFactory.HANJIN.findEnumObjectByPostCode(postCode) });
}

/**
 * CJ 도서산간 코드
 */
enum class CJIslandPostEnum(
    override val courierCompanyName: String,
    override val areaName: String,
    override val startPostCode: Int,
    override val endPostCode: Int,
    override val isJeJu: Boolean,
    override val isIsland: Boolean,
    override var enumObject: (postCode: Int) -> IslandPostEnum
) : IslandPostEnum {
    NONE("CJLOGISTICS", "NONE", 0, 0, false, false, { postCode -> CourierCompanyFactory.CJLOGISTICS.findEnumObjectByPostCode(postCode) });
}

/**
 * LOTTEGLOGIS 도서산간 코드
 */
enum class LotteIslandPostEnum(
    override val courierCompanyName: String,
    override val areaName: String,
    override val startPostCode: Int,
    override val endPostCode: Int,
    override val isJeJu: Boolean,
    override val isIsland: Boolean,
    override var enumObject: (postCode: Int) -> IslandPostEnum
) : IslandPostEnum {
    NONE("LOTTEGLOGIS", "NONE", 0, 0, false, false, { postCode -> CourierCompanyFactory.LOTTEGLOGIS.findEnumObjectByPostCode(postCode) });
}
