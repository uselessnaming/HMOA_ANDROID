package com.hmoa.core_domain.entity.navigation

enum class UserInfoRoute {
    UserInfoGraph,
    MyPage, //마이페이지 Route
    NoAuthMyPage, //인증되지 않았을 경우의 화면
    MyActivityRoute, //내 활동 화면
    MyCommentRoute, //작성한 댓글 Route
    MyPostRoute, //작성한 게시글 화면
    MyReview, //작성한 리뷰
    MyFavoriteCommentRoute, //좋아요 누른 댓글 화면
    MyFavoritePerfumeRoute, //좋아요 한 향수 화면
    EditProfileRoute, //프로필 수정 화면
    MyInfoRoute, //내 정보 화면
    MyBirthRoute, //출생연도 화면
    MyGenderRoute, //성별 화면
    OrderRecordRoute, //주문 내역
    RefundRoute, //환불 & 반품 화면
    RefundRecordRoute, //환불 & 반품 내역 화면
}