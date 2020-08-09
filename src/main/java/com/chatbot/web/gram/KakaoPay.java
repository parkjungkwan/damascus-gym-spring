package com.chatbot.web.gram;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import lombok.extern.java.Log;
@Data class AmountVO {
    private Integer total, tax_free, vat, point, discount;
}
@Data class CardVO {
    private String purchase_corp, purchase_corp_code;
    private String issuer_corp, issuer_corp_code;
    private String bin, card_type, install_month, approved_id, card_mid;
    private String interest_free_install, card_item_code;
}
@Data class KakaoPayApprovalVO {
    private String aid, tid, cid, sid;
    private String partner_order_id, partner_user_id, payment_method_type;
    private AmountVO amount;
    private CardVO card_info;
    private String item_name, item_code, payload;
    private Integer quantity, tax_free_amount, vat_amount;
    private Date created_at, approved_at;
}
@Data class KakaoPayReadyVO {
    private String tid, next_redirect_pc_url;
    private Date created_at;
}
@Service @Getter
@Log
public class KakaoPay {
    // document.getElementsByClassName("link_gnb")[1].click()
    // document.getElementById("userPhone").value="01055754786";
    // document.getElementById("userBirth").value="931229";
    // document.getElementsByClassName("btn_payask")[0].click()
    private static final String HOST = "https://kapi.kakao.com";

    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;


    public String kakaoPayReady(HashMap<String, String> data) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("여기2");
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "e523b4aefc19df61c38d857920fc96a3");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");  //가맹점코드, 10자, 테스트버전아닐시 카카오한테서 cid받아야함
        params.add("partner_order_id", "1");    //가맹점 주문번호, 최대100자
        params.add("partner_user_id",data.get("memberid"));   //가맹점 회원id, 최대100자
        params.add("item_name", "tardycash");        //상품명, 최대100자
        params.add("quantity", "1");    //상품수량, integer타입
        params.add("total_amount", data.get("amount"));  //상품총액 integer타입
        params.add("tax_free_amount", "0");   //상품비과세 금액, integer타입
        params.add("approval_url", "http://localhost:9000/kakaoPaySuccess");    //결제성공시 redirect url
        params.add("cancel_url", "http://localhost:9000/kakaoPayCancel");       //결제취소시 redirect url
        params.add("fail_url", "http://localhost:9000/kakaoPaySuccessFail");    //결제실패시 redirect url
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            log.info("" + kakaoPayReadyVO);
            //요청한 클라이언트가 pc 웹일 경우 redirect. 카카오톡으로 TMS를 보내기 위한 사용자입력화면이으로 redirect
            return kakaoPayReadyVO.getNext_redirect_pc_url();
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println("여기3");
        return "/pay";
    }


    public KakaoPayApprovalVO kakaoPayInfo(String pg_token, String amount, String memberid) {
        //log.info("KakaoPayInfoVO............................................");
        System.out.println("전달받은 어마운트랑 아이디 : " + amount + "," + memberid);
        System.out.println("kakaoPayInfo 메소드 도착");
        RestTemplate restTemplate = new RestTemplate();
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "e523b4aefc19df61c38d857920fc96a3");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        System.out.println("kakaoPayReadyVO : " + kakaoPayReadyVO);
        System.out.println("kakaoPayApprovalVO : " + kakaoPayApprovalVO);
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid()); //결제 고유 번호 20자
        params.add("partner_order_id", "1");
        params.add("partner_user_id", memberid);
        params.add("pg_token", pg_token);
        params.add("total_amount", amount);
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            //kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/order?cid=TC0ONETIME&tid="+kakaoPayReadyVO.getTid()), body, KakaoPayApprovalVO.class);
            System.out.println("kakaoPayApprovalVO : "+kakaoPayApprovalVO);
            return kakaoPayApprovalVO;
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}
