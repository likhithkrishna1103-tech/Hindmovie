package com.horis.cloudstreamplugins;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\r\u001a$\u0010\u000e\u001a\u0004\u0018\u0001H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\r\u001a\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f\u001a\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0014\u001a:\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0019H\u0086@¢\u0006\u0002\u0010\u001a\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"JSONParser", "Lcom/lagradost/nicehttp/ResponseParser;", "getJSONParser", "()Lcom/lagradost/nicehttp/ResponseParser;", "app", "Lcom/lagradost/nicehttp/Requests;", "getApp", "()Lcom/lagradost/nicehttp/Requests;", "parseJson", "T", "", "text", "", "(Ljava/lang/String;)Ljava/lang/Object;", "tryParseJson", "convertRuntimeToMinutes", "", "runtime", "bypass", "mainUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoToken", "newUrl", "id", "cookies", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NetflixMirrorProvider"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UtilsKt {

    @NotNull
    private static final ResponseParser JSONParser = new ResponseParser() { // from class: com.horis.cloudstreamplugins.UtilsKt$JSONParser$1
        private final ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);

        public final ObjectMapper getMapper() {
            return this.mapper;
        }

        public <T> T parse(String text, KClass<T> kClass) {
            return (T) this.mapper.readValue(text, JvmClassMappingKt.getJavaClass(kClass));
        }

        public <T> T parseSafe(String text, KClass<T> kClass) {
            try {
                return (T) this.mapper.readValue(text, JvmClassMappingKt.getJavaClass(kClass));
            } catch (Exception e) {
                return null;
            }
        }

        public String writeValueAsString(Object obj) {
            return this.mapper.writeValueAsString(obj);
        }
    };

    @NotNull
    private static final Requests app;

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.UtilsKt$bypass$1, reason: invalid class name */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {96, 106, 116, 117}, m = "bypass", n = {"mainUrl", "savedCookie", "savedTimestamp", "mainUrl", "savedCookie", "addhash", "savedTimestamp", "mainUrl", "savedCookie", "addhash", "verifyCheck", "verifyResponse", "requestBody", "savedTimestamp", "count", "mainUrl", "savedCookie", "addhash", "verifyCheck", "verifyResponse", "requestBody", "savedTimestamp", "count"}, nl = {102, 108, 117, 125}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.bypass(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.UtilsKt$getVideoToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0}, l = {171}, m = "getVideoToken", n = {"mainUrl", "newUrl", "id", "cookies", "requestBody", "headers"}, nl = {172}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.getVideoToken(null, null, null, null, (Continuation) this);
        }
    }

    static {
        Requests $this$app_u24lambda_u240 = new Requests((OkHttpClient) null, (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, JSONParser, 255, (DefaultConstructorMarker) null);
        $this$app_u24lambda_u240.setDefaultHeaders(MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36")));
        app = $this$app_u24lambda_u240;
    }

    @NotNull
    public static final ResponseParser getJSONParser() {
        return JSONParser;
    }

    @NotNull
    public static final Requests getApp() {
        return app;
    }

    public static final /* synthetic */ <T> T parseJson(String str) {
        ResponseParser jSONParser = getJSONParser();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) jSONParser.parse(str, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static final /* synthetic */ <T> T tryParseJson(String str) {
        try {
            ResponseParser jSONParser = getJSONParser();
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) jSONParser.parseSafe(str, Reflection.getOrCreateKotlinClass(Object.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final int convertRuntimeToMinutes(@NotNull String runtime) {
        int minutes;
        int totalMinutes = 0;
        List<String> parts = StringsKt.split$default(runtime, new String[]{" "}, false, 0, 6, (Object) null);
        for (String part : parts) {
            if (StringsKt.endsWith$default(part, "h", false, 2, (Object) null)) {
                Integer intOrNull = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.removeSuffix(part, "h")).toString());
                minutes = intOrNull != null ? intOrNull.intValue() : 0;
                totalMinutes += minutes * 60;
            } else if (StringsKt.endsWith$default(part, "m", false, 2, (Object) null)) {
                Integer intOrNull2 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.removeSuffix(part, "m")).toString());
                minutes = intOrNull2 != null ? intOrNull2.intValue() : 0;
                totalMinutes += minutes;
            }
        }
        return totalMinutes;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0274 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0353 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x037f A[Catch: Exception -> 0x03eb, TryCatch #3 {Exception -> 0x03eb, blocks: (B:61:0x0369, B:63:0x037f, B:65:0x0393, B:78:0x03e3, B:79:0x03ea), top: B:102:0x0369 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0354 -> B:105:0x035a). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object bypass(@NotNull String mainUrl, @NotNull Continuation<? super String> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        String savedCookie;
        Object obj;
        Object obj2;
        String mainUrl2;
        Object obj3;
        Object $result;
        Object obj4;
        int i;
        int count;
        AnonymousClass1 anonymousClass12;
        Object obj5;
        long savedTimestamp;
        String mainUrl3;
        Requests requests;
        String str;
        AnonymousClass1 anonymousClass13;
        String mainUrl4;
        long savedTimestamp2;
        String savedCookie2;
        String addhash;
        Object obj6;
        int count2;
        String addhash2;
        Continuation<? super String> continuation2;
        String verifyCheck;
        FormBody requestBody;
        String verifyCheck2;
        NiceResponse verifyResponse;
        AnonymousClass1 anonymousClass14;
        String verifyCheck3;
        NiceResponse verifyResponse2;
        Object obj7;
        Continuation<? super String> continuation3;
        Object obj8;
        AnonymousClass1 anonymousClass15;
        Object objPost$default;
        String mainUrl5;
        String savedCookie3;
        int count3;
        Continuation<? super String> continuation4;
        Continuation<? super String> continuation5;
        int count4;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object $result2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Pair<String, Long> cookie = NetflixMirrorStorage.INSTANCE.getCookie();
                String savedCookie4 = (String) cookie.component1();
                long savedTimestamp3 = ((Number) cookie.component2()).longValue();
                String str2 = savedCookie4;
                if (!(str2 == null || str2.length() == 0) && System.currentTimeMillis() - savedTimestamp3 < 54000000) {
                    Log.INSTANCE.d("NF", "savedCookie: " + savedCookie4);
                    return savedCookie4;
                }
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 12; RMX2117 Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/147.0.7727.55 Mobile Safari/537.36 /OS.Gatu v3.0"), TuplesKt.to("X-Requested-With", "app.netmirror.netmirrornew")});
                anonymousClass1.L$0 = mainUrl;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(savedCookie4);
                anonymousClass1.J$0 = savedTimestamp3;
                anonymousClass1.label = 1;
                savedCookie = savedCookie4;
                obj = "X-Requested-With";
                obj2 = "Mozilla/5.0 (Linux; Android 12; RMX2117 Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/147.0.7727.55 Mobile Safari/537.36 /OS.Gatu v3.0";
                AnonymousClass1 anonymousClass16 = anonymousClass1;
                mainUrl2 = "NF";
                obj3 = coroutine_suspended;
                $result = $result2;
                obj4 = "User-Agent";
                i = 1;
                count = 0;
                Object obj9 = Requests.get$default(app, mainUrl + "/mobile/home?app=1", mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass16, 4092, (Object) null);
                anonymousClass12 = anonymousClass16;
                if (obj9 == obj3) {
                    return obj3;
                }
                obj5 = obj9;
                savedTimestamp = savedTimestamp3;
                mainUrl3 = mainUrl;
                String addhash3 = ((NiceResponse) obj5).getDocument().select("body").attr("data-addhash");
                Log.INSTANCE.d(mainUrl2, "addhash: " + addhash3);
                requests = app;
                str = "https://userver.net52.cc/?jjoii=" + addhash3 + "&a=y&t=" + APIHolder.INSTANCE.getUnixTime();
                anonymousClass12.L$0 = mainUrl3;
                anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(savedCookie);
                anonymousClass12.L$2 = addhash3;
                anonymousClass12.J$0 = savedTimestamp;
                anonymousClass12.label = 2;
                long savedTimestamp4 = savedTimestamp;
                anonymousClass13 = anonymousClass12;
                mainUrl4 = mainUrl3;
                if (Requests.get$default(requests, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass13, 4094, (Object) null) != obj3) {
                    return obj3;
                }
                savedTimestamp2 = savedTimestamp4;
                savedCookie2 = savedCookie;
                addhash = addhash3;
                try {
                    obj6 = obj3;
                    count2 = 0;
                    addhash2 = addhash;
                    continuation2 = continuation;
                    verifyCheck = null;
                    requestBody = new FormBody.Builder((Charset) null, i, (DefaultConstructorMarker) null).addEncoded("verify", String.valueOf(addhash)).build();
                    verifyCheck2 = mainUrl4;
                    verifyResponse = null;
                    anonymousClass14 = anonymousClass13;
                    try {
                        anonymousClass14.L$0 = verifyCheck2;
                        anonymousClass14.L$1 = SpillingKt.nullOutSpilledVariable(savedCookie2);
                        anonymousClass14.L$2 = SpillingKt.nullOutSpilledVariable(addhash2);
                        anonymousClass14.L$3 = SpillingKt.nullOutSpilledVariable(verifyCheck);
                        anonymousClass14.L$4 = SpillingKt.nullOutSpilledVariable(verifyResponse);
                        anonymousClass14.L$5 = requestBody;
                        anonymousClass14.J$0 = savedTimestamp2;
                        anonymousClass14.I$0 = count2;
                        anonymousClass14.label = 3;
                        if (DelayKt.delay(10000L, anonymousClass14) == obj6) {
                            return obj6;
                        }
                        verifyCheck3 = verifyCheck;
                        verifyResponse2 = verifyResponse;
                        try {
                            try {
                                try {
                                    Requests requests2 = app;
                                    String str3 = verifyCheck2 + "/mobile/verify2.php";
                                    Pair[] pairArr = new Pair[2];
                                    Object obj10 = obj4;
                                    obj7 = obj2;
                                    pairArr[count] = TuplesKt.to(obj10, obj7);
                                    obj4 = obj10;
                                    pairArr[1] = TuplesKt.to(obj8, "XMLHttpRequest");
                                    Map mapMapOf2 = MapsKt.mapOf(pairArr);
                                    RequestBody requestBody2 = (RequestBody) requestBody;
                                    anonymousClass14.L$0 = verifyCheck2;
                                    anonymousClass14.L$1 = SpillingKt.nullOutSpilledVariable(savedCookie2);
                                    anonymousClass14.L$2 = SpillingKt.nullOutSpilledVariable(addhash2);
                                    anonymousClass14.L$3 = SpillingKt.nullOutSpilledVariable(verifyCheck3);
                                    anonymousClass14.L$4 = SpillingKt.nullOutSpilledVariable(verifyResponse2);
                                    anonymousClass14.L$5 = requestBody;
                                    anonymousClass14.J$0 = savedTimestamp2;
                                    anonymousClass14.I$0 = count2;
                                    anonymousClass14.label = 4;
                                    objPost$default = Requests.post$default(requests2, str3, mapMapOf2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass15, 65276, (Object) null);
                                    if (objPost$default != obj6) {
                                        return obj6;
                                    }
                                    mainUrl5 = verifyCheck2;
                                    savedCookie3 = savedCookie2;
                                    count3 = count2;
                                    $result2 = objPost$default;
                                    continuation4 = continuation3;
                                    try {
                                        try {
                                            NiceResponse verifyResponse3 = (NiceResponse) $result2;
                                            String verifyCheck4 = verifyResponse3.getText();
                                            Log.INSTANCE.d(mainUrl2, "verifyCheck: " + verifyCheck4);
                                            count4 = count3 + 1;
                                            if (count4 <= 7) {
                                                throw new Exception("Failed to verify cookie");
                                            }
                                            obj = obj8;
                                            if (StringsKt.contains$default(verifyCheck4, "\"statusup\":\"All Done\"", false, 2, (Object) null)) {
                                                String newCookie = (String) verifyResponse3.getCookies().get("t_hash_t");
                                                if (newCookie == null) {
                                                    newCookie = "";
                                                }
                                                if (newCookie.length() > 0) {
                                                    NetflixMirrorStorage.INSTANCE.saveCookie(newCookie);
                                                }
                                                Log.INSTANCE.d(mainUrl2, "newCookie: " + newCookie);
                                                return newCookie;
                                            }
                                            continuation2 = continuation5;
                                            obj2 = obj7;
                                            savedCookie2 = savedCookie3;
                                            verifyCheck = verifyCheck4;
                                            count = 0;
                                            count2 = count4;
                                            verifyResponse = verifyResponse3;
                                            verifyCheck2 = mainUrl5;
                                            anonymousClass14 = anonymousClass15;
                                            anonymousClass14.L$0 = verifyCheck2;
                                            anonymousClass14.L$1 = SpillingKt.nullOutSpilledVariable(savedCookie2);
                                            anonymousClass14.L$2 = SpillingKt.nullOutSpilledVariable(addhash2);
                                            anonymousClass14.L$3 = SpillingKt.nullOutSpilledVariable(verifyCheck);
                                            anonymousClass14.L$4 = SpillingKt.nullOutSpilledVariable(verifyResponse);
                                            anonymousClass14.L$5 = requestBody;
                                            anonymousClass14.J$0 = savedTimestamp2;
                                            anonymousClass14.I$0 = count2;
                                            anonymousClass14.label = 3;
                                            if (DelayKt.delay(10000L, anonymousClass14) == obj6) {
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            NetflixMirrorStorage.INSTANCE.clearCookie();
                                            throw e;
                                        }
                                        continuation5 = continuation4;
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    NetflixMirrorStorage.INSTANCE.clearCookie();
                                    throw e;
                                }
                                anonymousClass15 = anonymousClass14;
                            } catch (Exception e4) {
                                e = e4;
                            }
                            continuation3 = continuation2;
                            obj8 = obj;
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        NetflixMirrorStorage.INSTANCE.clearCookie();
                        throw e;
                    }
                } catch (Exception e7) {
                    e = e7;
                    NetflixMirrorStorage.INSTANCE.clearCookie();
                    throw e;
                }
                break;
            case 1:
                long savedTimestamp5 = anonymousClass1.J$0;
                String savedCookie5 = (String) anonymousClass1.L$1;
                String mainUrl6 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result2);
                anonymousClass12 = anonymousClass1;
                obj3 = coroutine_suspended;
                savedCookie = savedCookie5;
                obj5 = $result2;
                $result = obj5;
                obj = "X-Requested-With";
                obj2 = "Mozilla/5.0 (Linux; Android 12; RMX2117 Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/147.0.7727.55 Mobile Safari/537.36 /OS.Gatu v3.0";
                obj4 = "User-Agent";
                savedTimestamp = savedTimestamp5;
                i = 1;
                count = 0;
                mainUrl3 = mainUrl6;
                mainUrl2 = "NF";
                String addhash32 = ((NiceResponse) obj5).getDocument().select("body").attr("data-addhash");
                Log.INSTANCE.d(mainUrl2, "addhash: " + addhash32);
                requests = app;
                str = "https://userver.net52.cc/?jjoii=" + addhash32 + "&a=y&t=" + APIHolder.INSTANCE.getUnixTime();
                anonymousClass12.L$0 = mainUrl3;
                anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(savedCookie);
                anonymousClass12.L$2 = addhash32;
                anonymousClass12.J$0 = savedTimestamp;
                anonymousClass12.label = 2;
                long savedTimestamp42 = savedTimestamp;
                anonymousClass13 = anonymousClass12;
                mainUrl4 = mainUrl3;
                if (Requests.get$default(requests, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass13, 4094, (Object) null) != obj3) {
                }
                break;
            case 2:
                long savedTimestamp6 = anonymousClass1.J$0;
                String addhash4 = (String) anonymousClass1.L$2;
                savedCookie2 = (String) anonymousClass1.L$1;
                String mainUrl7 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result2);
                mainUrl4 = mainUrl7;
                anonymousClass13 = anonymousClass1;
                $result = $result2;
                obj3 = coroutine_suspended;
                obj = "X-Requested-With";
                obj2 = "Mozilla/5.0 (Linux; Android 12; RMX2117 Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/147.0.7727.55 Mobile Safari/537.36 /OS.Gatu v3.0";
                obj4 = "User-Agent";
                savedTimestamp2 = savedTimestamp6;
                mainUrl2 = "NF";
                count = 0;
                addhash = addhash4;
                i = 1;
                obj6 = obj3;
                count2 = 0;
                addhash2 = addhash;
                continuation2 = continuation;
                verifyCheck = null;
                requestBody = new FormBody.Builder((Charset) null, i, (DefaultConstructorMarker) null).addEncoded("verify", String.valueOf(addhash)).build();
                verifyCheck2 = mainUrl4;
                verifyResponse = null;
                anonymousClass14 = anonymousClass13;
                anonymousClass14.L$0 = verifyCheck2;
                anonymousClass14.L$1 = SpillingKt.nullOutSpilledVariable(savedCookie2);
                anonymousClass14.L$2 = SpillingKt.nullOutSpilledVariable(addhash2);
                anonymousClass14.L$3 = SpillingKt.nullOutSpilledVariable(verifyCheck);
                anonymousClass14.L$4 = SpillingKt.nullOutSpilledVariable(verifyResponse);
                anonymousClass14.L$5 = requestBody;
                anonymousClass14.J$0 = savedTimestamp2;
                anonymousClass14.I$0 = count2;
                anonymousClass14.label = 3;
                if (DelayKt.delay(10000L, anonymousClass14) == obj6) {
                }
                break;
            case 3:
                int count5 = anonymousClass1.I$0;
                savedTimestamp2 = anonymousClass1.J$0;
                FormBody requestBody3 = (FormBody) anonymousClass1.L$5;
                NiceResponse verifyResponse4 = (NiceResponse) anonymousClass1.L$4;
                String verifyCheck5 = (String) anonymousClass1.L$3;
                String addhash5 = (String) anonymousClass1.L$2;
                String savedCookie6 = (String) anonymousClass1.L$1;
                String mainUrl8 = (String) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    requestBody = requestBody3;
                    savedCookie2 = savedCookie6;
                    verifyCheck3 = verifyCheck5;
                    $result = $result2;
                    obj = "X-Requested-With";
                    obj2 = "Mozilla/5.0 (Linux; Android 12; RMX2117 Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/147.0.7727.55 Mobile Safari/537.36 /OS.Gatu v3.0";
                    obj4 = "User-Agent";
                    mainUrl2 = "NF";
                    addhash2 = addhash5;
                    verifyCheck2 = mainUrl8;
                    obj6 = coroutine_suspended;
                    verifyResponse2 = verifyResponse4;
                    count2 = count5;
                    count = 0;
                    anonymousClass14 = anonymousClass1;
                    continuation2 = continuation;
                    Requests requests22 = app;
                    String str32 = verifyCheck2 + "/mobile/verify2.php";
                    Pair[] pairArr2 = new Pair[2];
                    Object obj102 = obj4;
                    obj7 = obj2;
                    pairArr2[count] = TuplesKt.to(obj102, obj7);
                    obj4 = obj102;
                    continuation3 = continuation2;
                    obj8 = obj;
                    pairArr2[1] = TuplesKt.to(obj8, "XMLHttpRequest");
                    Map mapMapOf22 = MapsKt.mapOf(pairArr2);
                    RequestBody requestBody22 = (RequestBody) requestBody;
                    anonymousClass14.L$0 = verifyCheck2;
                    anonymousClass14.L$1 = SpillingKt.nullOutSpilledVariable(savedCookie2);
                    anonymousClass14.L$2 = SpillingKt.nullOutSpilledVariable(addhash2);
                    anonymousClass14.L$3 = SpillingKt.nullOutSpilledVariable(verifyCheck3);
                    anonymousClass14.L$4 = SpillingKt.nullOutSpilledVariable(verifyResponse2);
                    anonymousClass14.L$5 = requestBody;
                    anonymousClass14.J$0 = savedTimestamp2;
                    anonymousClass14.I$0 = count2;
                    anonymousClass14.label = 4;
                    anonymousClass15 = anonymousClass14;
                    objPost$default = Requests.post$default(requests22, str32, mapMapOf22, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody22, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass15, 65276, (Object) null);
                    if (objPost$default != obj6) {
                    }
                } catch (Exception e8) {
                    e = e8;
                    NetflixMirrorStorage.INSTANCE.clearCookie();
                    throw e;
                }
                break;
            case 4:
                count3 = anonymousClass1.I$0;
                savedTimestamp2 = anonymousClass1.J$0;
                FormBody requestBody4 = (FormBody) anonymousClass1.L$5;
                String addhash6 = (String) anonymousClass1.L$2;
                String savedCookie7 = (String) anonymousClass1.L$1;
                String mainUrl9 = (String) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    anonymousClass15 = anonymousClass1;
                    $result = $result2;
                    obj8 = "X-Requested-With";
                    obj7 = "Mozilla/5.0 (Linux; Android 12; RMX2117 Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/147.0.7727.55 Mobile Safari/537.36 /OS.Gatu v3.0";
                    obj4 = "User-Agent";
                    mainUrl2 = "NF";
                    savedCookie3 = savedCookie7;
                    obj6 = coroutine_suspended;
                    addhash2 = addhash6;
                    mainUrl5 = mainUrl9;
                    requestBody = requestBody4;
                    continuation4 = continuation;
                    NiceResponse verifyResponse32 = (NiceResponse) $result2;
                    String verifyCheck42 = verifyResponse32.getText();
                    continuation5 = continuation4;
                    Log.INSTANCE.d(mainUrl2, "verifyCheck: " + verifyCheck42);
                    count4 = count3 + 1;
                    if (count4 <= 7) {
                    }
                } catch (Exception e9) {
                    e = e9;
                    NetflixMirrorStorage.INSTANCE.clearCookie();
                    throw e;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getVideoToken(@NotNull String mainUrl, @NotNull String newUrl, @NotNull String id, @NotNull Map<String, String> map, @NotNull Continuation<? super String> continuation) throws JSONException {
        C00161 c00161;
        String str;
        int i;
        if (continuation instanceof C00161) {
            c00161 = (C00161) continuation;
            if ((c00161.label & Integer.MIN_VALUE) != 0) {
                c00161.label -= Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuation);
            }
        }
        Object $result = c00161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00161.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RequestBody requestBodyBuild = new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).addEncoded("id", id).build();
                Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "*/*"), TuplesKt.to("Accept-Language", "en-US,en;q=0.5"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("Content-Length", "11"), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"), TuplesKt.to("Host", "net22.cc"), TuplesKt.to("Origin", mainUrl + '/'), TuplesKt.to("Priority", "u=0"), TuplesKt.to("Referer", mainUrl + "/home"), TuplesKt.to("Sec-Fetch-Dest", "empty"), TuplesKt.to("Sec-Fetch-Mode", "cors"), TuplesKt.to("Sec-Fetch-Site", "same-origin"), TuplesKt.to("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:139.0) Gecko/20100101 Firefox/139.0"), TuplesKt.to("X-Requested-With", "XMLHttpRequest")});
                c00161.L$0 = SpillingKt.nullOutSpilledVariable(mainUrl);
                c00161.L$1 = SpillingKt.nullOutSpilledVariable(newUrl);
                c00161.L$2 = SpillingKt.nullOutSpilledVariable(id);
                c00161.L$3 = SpillingKt.nullOutSpilledVariable(map);
                c00161.L$4 = SpillingKt.nullOutSpilledVariable(requestBodyBuild);
                c00161.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                c00161.label = 1;
                str = null;
                i = 2;
                $result = Requests.post$default(app, mainUrl + "/play.php", headers, (String) null, (Map) null, map, (Map) null, (List) null, (Object) null, requestBodyBuild, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00161, 65260, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                str = null;
                i = 2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String json = ((NiceResponse) $result).getText();
        String h = new JSONObject(json).getString("h");
        return StringsKt.substringAfter$default(h, "in=", str, i, str);
    }
}
