package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/phisher98/Blakiteapi;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQualityFromString", "", "q", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Blakiteapi extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Blakiteapi";

    @NotNull
    private final String mainUrl = "https://blakiteapi.xyz";

    /* JADX INFO: renamed from: com.phisher98.Blakiteapi$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Blakiteapi", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {329, 342}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "apiurl", "url", "referer", "subtitleCallback", "callback", "apiurl", "responseText", "json", "data", "quality", "format", "dataId", "streamUrl", "success"}, nl = {331, 341}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Blakiteapi.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x014e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0213 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0214  */
    /* JADX WARN: Code duplicated, block: B:25:0x022c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) throws JSONException {
        AnonymousClass1 anonymousClass1;
        Object obj;
        Object obj2;
        String referer2;
        String referer3;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String apiurl;
        String responseText;
        JSONObject json;
        boolean success;
        boolean success2;
        Object objNewExtractorLink;
        String referer4;
        Function1<? super ExtractorLink, Unit> function5;
        JSONObject json2;
        String url2;
        Function1<? super ExtractorLink, Unit> function6;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String apiurl2 = getMainUrl() + "/api/get.php?id=" + StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null) + "&tmdbId=" + StringsKt.substringBefore$default(StringsKt.substringAfter$default(url, "embed/", (String) null, 2, (Object) null), "/", (String) null, 2, (Object) null);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(url);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                anonymousClass2.L$3 = function2;
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(apiurl2);
                anonymousClass2.label = 1;
                obj2 = Requests.get$default(app, apiurl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass2, 4094, (Object) null);
                anonymousClass2 = anonymousClass2;
                if (obj2 == obj) {
                    return obj;
                }
                referer2 = url;
                referer3 = referer;
                function3 = function1;
                function4 = function2;
                apiurl = apiurl2;
                responseText = ((NiceResponse) obj2).getText();
                json = new JSONObject(responseText);
                success = json.optBoolean("success", false);
                if (success) {
                    JSONObject data = json.getJSONObject("data");
                    String quality = data.optString("quality", "480p");
                    String format = data.optString("format", "MP4");
                    String dataId = data.optString("dataId", "");
                    String streamUrl = getMainUrl() + "/stream/" + dataId + "." + format;
                    String streamUrl2 = getName();
                    String quality2 = getName();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2(quality, null);
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(referer2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(apiurl);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(responseText);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(json);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(data);
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(quality);
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(format);
                    anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(dataId);
                    anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(streamUrl);
                    anonymousClass2.L$12 = function4;
                    anonymousClass2.Z$0 = success;
                    anonymousClass2.label = 2;
                    success2 = success;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(streamUrl2, quality2, streamUrl, infer_type, anonymousClass3, anonymousClass2);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    referer4 = referer3;
                    function5 = function4;
                    json2 = json;
                    url2 = referer2;
                    function6 = function5;
                    function5.invoke(objNewExtractorLink);
                }
                return Unit.INSTANCE;
            case 1:
                String apiurl3 = (String) anonymousClass2.L$4;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) anonymousClass2.L$3;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) anonymousClass2.L$2;
                String referer5 = (String) anonymousClass2.L$1;
                String url3 = (String) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                apiurl = apiurl3;
                obj = coroutine_suspended;
                function4 = function7;
                function3 = function8;
                referer3 = referer5;
                referer2 = url3;
                obj2 = $result;
                responseText = ((NiceResponse) obj2).getText();
                json = new JSONObject(responseText);
                success = json.optBoolean("success", false);
                if (success) {
                    JSONObject data2 = json.getJSONObject("data");
                    String quality3 = data2.optString("quality", "480p");
                    String format2 = data2.optString("format", "MP4");
                    String dataId2 = data2.optString("dataId", "");
                    String streamUrl3 = getMainUrl() + "/stream/" + dataId2 + "." + format2;
                    String streamUrl4 = getName();
                    String quality4 = getName();
                    ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(quality3, null);
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(referer2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(apiurl);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(responseText);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(json);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(data2);
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(quality3);
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(format2);
                    anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(dataId2);
                    anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(streamUrl3);
                    anonymousClass2.L$12 = function4;
                    anonymousClass2.Z$0 = success;
                    anonymousClass2.label = 2;
                    success2 = success;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(streamUrl4, quality4, streamUrl3, infer_type2, anonymousClass4, anonymousClass2);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    referer4 = referer3;
                    function5 = function4;
                    json2 = json;
                    url2 = referer2;
                    function6 = function5;
                    function5.invoke(objNewExtractorLink);
                }
                return Unit.INSTANCE;
            case 2:
                boolean success3 = anonymousClass2.Z$0;
                function5 = (Function1) anonymousClass2.L$12;
                JSONObject json3 = (JSONObject) anonymousClass2.L$6;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) anonymousClass2.L$3;
                String referer6 = (String) anonymousClass2.L$1;
                url2 = (String) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                referer4 = referer6;
                function6 = function9;
                success2 = success3;
                objNewExtractorLink = $result;
                json2 = json3;
                function5.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Blakiteapi$getUrl$2, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Blakiteapi$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$quality = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = Blakiteapi.this.new AnonymousClass2(this.$quality, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setQuality(Blakiteapi.this.getQualityFromString(this.$quality));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getQualityFromString(String q) {
        if (StringsKt.contains(q, "1080", true)) {
            return Qualities.P1080.getValue();
        }
        if (StringsKt.contains(q, "720", true)) {
            return Qualities.P720.getValue();
        }
        if (StringsKt.contains(q, "480", true)) {
            return Qualities.P480.getValue();
        }
        return StringsKt.contains(q, "360", true) ? Qualities.P360.getValue() : Qualities.Unknown.getValue();
    }
}
