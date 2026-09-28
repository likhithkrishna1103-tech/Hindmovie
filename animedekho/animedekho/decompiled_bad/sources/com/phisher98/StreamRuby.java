package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StreamRuby;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class StreamRuby extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "StreamRuby";

    @NotNull
    private final String mainUrl = "https://rubystm.com";

    /* JADX INFO: renamed from: com.phisher98.StreamRuby$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamRuby", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {281, 300}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "cleanedUrl", "url", "referer", "subtitleCallback", "callback", "cleanedUrl", "response", "scriptData", "headers", "link"}, nl = {285, 299}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamRuby.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:20:0x0115  */
    /* JADX WARN: Code duplicated, block: B:21:0x011a  */
    /* JADX WARN: Code duplicated, block: B:23:0x011d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        char c;
        Object obj2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String cleanedUrl;
        Element elementSelectFirst;
        String strData;
        MatchResult matchResultFind$default;
        List groupValues;
        String link;
        Object objNewExtractorLink;
        String cleanedUrl2;
        Document response;
        String url3;
        String url4;
        Map headers;
        Function1<? super ExtractorLink, Unit> function5;
        String scriptData;
        Function1<? super SubtitleFile, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
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
                String cleanedUrl3 = StringsKt.replace$default(url, "/e", "", false, 4, (Object) null);
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(url);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                anonymousClass2.L$3 = function2;
                anonymousClass2.L$4 = cleanedUrl3;
                anonymousClass2.label = 1;
                obj = coroutine_suspended;
                c = 1;
                obj2 = Requests.get$default(app, cleanedUrl3, mapMapOf, cleanedUrl3, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass2, 4088, (Object) null);
                anonymousClass2 = anonymousClass2;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                cleanedUrl = cleanedUrl3;
                Document response2 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = response2.selectFirst("script:containsData(vplayer)");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                if (strData == null) {
                    strData = "";
                }
                String scriptData2 = strData;
                Pair[] pairArr = new Pair[6];
                pairArr[0] = TuplesKt.to("Accept", "*/*");
                pairArr[c] = TuplesKt.to("Connection", "keep-alive");
                pairArr[2] = TuplesKt.to("Sec-Fetch-Dest", "empty");
                pairArr[3] = TuplesKt.to("Sec-Fetch-Mode", "cors");
                pairArr[4] = TuplesKt.to("Sec-Fetch-Site", "cross-site");
                pairArr[5] = TuplesKt.to("Origin", cleanedUrl);
                Map headers2 = MapsKt.mapOf(pairArr);
                matchResultFind$default = Regex.find$default(new Regex("file:\"(.*)\""), scriptData2, 0, 2, (Object) null);
                if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null && (link = (String) CollectionsKt.getOrNull(groupValues, 1)) != null) {
                    String name = getName();
                    String name2 = getName();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    StreamRuby$getUrl$2$1 streamRuby$getUrl$2$1 = new StreamRuby$getUrl$2$1(this, headers2, null);
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(cleanedUrl);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(response2);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(scriptData2);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(headers2);
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(link);
                    anonymousClass2.L$9 = function4;
                    anonymousClass2.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, link, infer_type, streamRuby$getUrl$2$1, anonymousClass2);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    String str = cleanedUrl;
                    cleanedUrl2 = referer2;
                    response = response2;
                    url3 = url2;
                    url4 = str;
                    headers = headers2;
                    function5 = function4;
                    scriptData = scriptData2;
                    function6 = function3;
                    function7 = function5;
                    function5.invoke(objNewExtractorLink);
                }
                return Unit.INSTANCE;
            case 1:
                String cleanedUrl4 = (String) anonymousClass2.L$4;
                Function1<? super ExtractorLink, Unit> function8 = (Function1) anonymousClass2.L$3;
                Function1<? super SubtitleFile, Unit> function9 = (Function1) anonymousClass2.L$2;
                referer2 = (String) anonymousClass2.L$1;
                url2 = (String) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                function4 = function8;
                function3 = function9;
                obj2 = $result;
                c = 1;
                cleanedUrl = cleanedUrl4;
                Document response3 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = response3.selectFirst("script:containsData(vplayer)");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                if (strData == null) {
                    strData = "";
                }
                String scriptData3 = strData;
                Pair[] pairArr2 = new Pair[6];
                pairArr2[0] = TuplesKt.to("Accept", "*/*");
                pairArr2[c] = TuplesKt.to("Connection", "keep-alive");
                pairArr2[2] = TuplesKt.to("Sec-Fetch-Dest", "empty");
                pairArr2[3] = TuplesKt.to("Sec-Fetch-Mode", "cors");
                pairArr2[4] = TuplesKt.to("Sec-Fetch-Site", "cross-site");
                pairArr2[5] = TuplesKt.to("Origin", cleanedUrl);
                Map headers3 = MapsKt.mapOf(pairArr2);
                matchResultFind$default = Regex.find$default(new Regex("file:\"(.*)\""), scriptData3, 0, 2, (Object) null);
                if (matchResultFind$default == null) {
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) anonymousClass2.L$9;
                headers = (Map) anonymousClass2.L$7;
                scriptData = (String) anonymousClass2.L$6;
                response = (Document) anonymousClass2.L$5;
                url4 = (String) anonymousClass2.L$4;
                function7 = (Function1) anonymousClass2.L$3;
                function6 = (Function1) anonymousClass2.L$2;
                cleanedUrl2 = (String) anonymousClass2.L$1;
                url3 = (String) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function5.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
