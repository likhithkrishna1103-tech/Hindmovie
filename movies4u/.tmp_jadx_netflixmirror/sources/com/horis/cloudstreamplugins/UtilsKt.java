package com.horis.cloudstreamplugins;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object bypass(@org.jetbrains.annotations.NotNull java.lang.String r52, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r53) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.UtilsKt.bypass(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object getVideoToken(@org.jetbrains.annotations.NotNull java.lang.String r27, @org.jetbrains.annotations.NotNull java.lang.String r28, @org.jetbrains.annotations.NotNull java.lang.String r29, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> r30, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r31) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.UtilsKt.getVideoToken(java.lang.String, java.lang.String, java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
