package com.phisher98;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.JsUnpacker;
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
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/AWSStream;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Response", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/AWSStream\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,448:1\n73#2,5:449\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/AWSStream\n*L\n148#1:449,5\n*E\n"})
public class AWSStream extends ExtractorApi {

    @NotNull
    private final String name = "AWSStream";

    @NotNull
    private final String mainUrl = "https://z.awstream.net";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.AWSStream$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AWSStream", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {144, 148, 151, 170}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "extractedHash", "$this", "url", "referer", "subtitleCallback", "callback", "extractedHash", "doc", "m3u8Url", "header", "formdata", "$this", "url", "referer", "subtitleCallback", "callback", "extractedHash", "doc", "m3u8Url", "header", "formdata", "response", "m3u8", "$this", "url", "referer", "subtitleCallback", "callback", "extractedHash", "doc", "m3u8Url", "header", "formdata", "response", "m3u8", "extractedPack", "unpacked", "subtitleUrl"}, nl = {145, 449, 150, 169}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
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
            return AWSStream.getUrl$suspendImpl(AWSStream.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
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

    /* JADX WARN: Code duplicated, block: B:22:0x0296 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0297  */
    /* JADX WARN: Code duplicated, block: B:31:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:35:0x0334 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0335  */
    /* JADX WARN: Code duplicated, block: B:39:0x0349  */
    /* JADX WARN: Code duplicated, block: B:40:0x034e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0351  */
    /* JADX WARN: Code duplicated, block: B:45:0x035e  */
    /* JADX WARN: Code duplicated, block: B:53:0x03fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(AWSStream $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        int i;
        char c;
        char c2;
        String referer2;
        Function1<? super ExtractorLink, Unit> function3;
        Object obj2;
        String referer3;
        String url2;
        Function1<? super SubtitleFile, Unit> function4;
        Document doc;
        String m3u8Url;
        Map header;
        Map formdata;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String extractedHash;
        Object objPost$default;
        String m3u8Url2;
        Map header2;
        Map formdata2;
        Document doc2;
        Function1<? super SubtitleFile, Unit> function7;
        Function1<? super ExtractorLink, Unit> function8;
        AWSStream $this2;
        Object safe;
        Response response;
        String m3u8;
        Response response2;
        AWSStream $this3;
        Map header3;
        Function1<? super ExtractorLink, Unit> function9;
        String m3u8Url3;
        Map formdata3;
        Object m3u9;
        Element elementSelectFirst;
        String extractedPack;
        String unpacked;
        MatchResult matchResultFind$default;
        List groupValues;
        String subtitleUrl;
        Object objNewSubtitleFile$default;
        String m3u10;
        Object $result;
        Function1<? super SubtitleFile, Unit> function10;
        String subtitleUrl2;
        String url3;
        String m3u8Url4;
        Map header4;
        String unpacked2;
        AWSStream $this4 = $this;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = $this4.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = $this4.new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result2 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                String extractedHash2 = StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null);
                Requests app = MainActivityKt.getApp();
                anonymousClass2.L$0 = $this4;
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                anonymousClass2.L$3 = function1;
                anonymousClass2.L$4 = function2;
                anonymousClass2.L$5 = extractedHash2;
                anonymousClass2.label = 1;
                obj = coroutine_suspended;
                i = 2;
                c = 0;
                c2 = 1;
                Object obj3 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass2, 4094, (Object) null);
                anonymousClass2 = anonymousClass2;
                if (obj3 == obj) {
                    return obj;
                }
                referer2 = referer;
                function3 = function2;
                obj2 = obj3;
                referer3 = extractedHash2;
                url2 = url;
                function4 = function1;
                doc = ((NiceResponse) obj2).getDocument();
                m3u8Url = $this4.getMainUrl() + "/player/index.php?data=" + referer3 + "&do=getVideo";
                header = MapsKt.mapOf(TuplesKt.to("x-requested-with", "XMLHttpRequest"));
                Pair[] pairArr = new Pair[i];
                pairArr[c] = TuplesKt.to("hash", referer3);
                pairArr[c2] = TuplesKt.to("r", $this4.getMainUrl());
                formdata = MapsKt.mapOf(pairArr);
                Requests app2 = MainActivityKt.getApp();
                anonymousClass2.L$0 = $this4;
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                anonymousClass2.L$3 = function4;
                anonymousClass2.L$4 = function3;
                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(referer3);
                anonymousClass2.L$6 = doc;
                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(m3u8Url);
                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(header);
                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(formdata);
                anonymousClass2.label = i;
                AnonymousClass1 anonymousClass3 = anonymousClass2;
                function5 = function3;
                function6 = function4;
                extractedHash = referer3;
                objPost$default = Requests.post$default(app2, m3u8Url, header, (String) null, (Map) null, (Map) null, formdata, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass3, 65500, (Object) null);
                anonymousClass2 = anonymousClass3;
                if (objPost$default == obj) {
                    return obj;
                }
                m3u8Url2 = m3u8Url;
                header2 = header;
                formdata2 = formdata;
                doc2 = doc;
                function7 = function6;
                function8 = function5;
                $this2 = $this4;
                NiceResponse this_$iv = (NiceResponse) objPost$default;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Response.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                response = (Response) safe;
                if (response != null && (m3u8 = response.getVideoSource()) != null) {
                    String name = $this2.getName();
                    String name2 = $this2.getName();
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                    AWSStream$getUrl$2$1 aWSStream$getUrl$2$1 = new AWSStream$getUrl$2$1(null);
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    anonymousClass2.L$3 = function7;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(extractedHash);
                    anonymousClass2.L$6 = doc2;
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(header2);
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(formdata2);
                    anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(response);
                    anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(m3u8);
                    anonymousClass2.L$12 = function8;
                    anonymousClass2.label = 3;
                    AnonymousClass1 anonymousClass4 = anonymousClass2;
                    $result2 = ExtractorApiKt.newExtractorLink(name, name2, m3u8, extractorLinkType, aWSStream$getUrl$2$1, anonymousClass4);
                    anonymousClass2 = anonymousClass4;
                    if ($result2 == obj) {
                        return obj;
                    }
                    Map map = header2;
                    response2 = response;
                    $this3 = $this2;
                    header3 = map;
                    function9 = function8;
                    m3u8Url3 = m3u8Url2;
                    formdata3 = formdata2;
                    m3u9 = m3u8;
                    function9.invoke($result2);
                    elementSelectFirst = doc2.selectFirst("script:containsData(function(p,a,c,k,e,d))");
                    if (elementSelectFirst != null) {
                        extractedPack = elementSelectFirst.data();
                    } else {
                        extractedPack = null;
                    }
                    if (extractedPack == null) {
                        extractedPack = "";
                    }
                    unpacked = new JsUnpacker(extractedPack).unpack();
                    if (unpacked != null && (matchResultFind$default = Regex.find$default(new Regex("\"kind\":\\s*\"captions\"\\s*,\\s*\"file\":\\s*\"(https.*?\\.srt)"), unpacked, 0, 2, (Object) null)) != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (subtitleUrl = (String) groupValues.get(1)) != null) {
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(extractedHash);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(m3u8Url3);
                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(header3);
                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(formdata3);
                        anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(response2);
                        anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(m3u9);
                        anonymousClass2.L$12 = SpillingKt.nullOutSpilledVariable(extractedPack);
                        anonymousClass2.L$13 = SpillingKt.nullOutSpilledVariable(unpacked);
                        anonymousClass2.L$14 = SpillingKt.nullOutSpilledVariable(subtitleUrl);
                        anonymousClass2.L$15 = function7;
                        anonymousClass2.label = 4;
                        objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default("English", subtitleUrl, (Function2) null, anonymousClass2, 4, (Object) null);
                        if (objNewSubtitleFile$default == obj) {
                            return obj;
                        }
                        Object obj4 = m3u9;
                        m3u10 = extractedPack;
                        $result = obj4;
                        function10 = function7;
                        subtitleUrl2 = null;
                        url3 = url2;
                        m3u8Url4 = m3u8Url3;
                        header4 = header3;
                        unpacked2 = unpacked;
                        function10.invoke(objNewSubtitleFile$default);
                        header3 = header4;
                        m3u8Url3 = m3u8Url4;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                String extractedHash3 = (String) anonymousClass2.L$5;
                function3 = (Function1) anonymousClass2.L$4;
                Function1<? super SubtitleFile, Unit> function11 = (Function1) anonymousClass2.L$3;
                String referer4 = (String) anonymousClass2.L$2;
                String url4 = (String) anonymousClass2.L$1;
                $this4 = (AWSStream) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result2);
                referer2 = referer4;
                url2 = url4;
                c = 0;
                c2 = 1;
                referer3 = extractedHash3;
                obj = coroutine_suspended;
                function4 = function11;
                i = 2;
                obj2 = $result2;
                doc = ((NiceResponse) obj2).getDocument();
                m3u8Url = $this4.getMainUrl() + "/player/index.php?data=" + referer3 + "&do=getVideo";
                header = MapsKt.mapOf(TuplesKt.to("x-requested-with", "XMLHttpRequest"));
                Pair[] pairArr2 = new Pair[i];
                pairArr2[c] = TuplesKt.to("hash", referer3);
                pairArr2[c2] = TuplesKt.to("r", $this4.getMainUrl());
                formdata = MapsKt.mapOf(pairArr2);
                Requests app3 = MainActivityKt.getApp();
                anonymousClass2.L$0 = $this4;
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                anonymousClass2.L$3 = function4;
                anonymousClass2.L$4 = function3;
                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(referer3);
                anonymousClass2.L$6 = doc;
                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(m3u8Url);
                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(header);
                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(formdata);
                anonymousClass2.label = i;
                AnonymousClass1 anonymousClass5 = anonymousClass2;
                function5 = function3;
                function6 = function4;
                extractedHash = referer3;
                objPost$default = Requests.post$default(app3, m3u8Url, header, (String) null, (Map) null, (Map) null, formdata, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass5, 65500, (Object) null);
                anonymousClass2 = anonymousClass5;
                if (objPost$default == obj) {
                    return obj;
                }
                m3u8Url2 = m3u8Url;
                header2 = header;
                formdata2 = formdata;
                doc2 = doc;
                function7 = function6;
                function8 = function5;
                $this2 = $this4;
                NiceResponse this_$iv2 = (NiceResponse) objPost$default;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Response.class));
                response = (Response) safe;
                if (response != null) {
                    String name3 = $this2.getName();
                    String name4 = $this2.getName();
                    ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                    AWSStream$getUrl$2$1 aWSStream$getUrl$2$2 = new AWSStream$getUrl$2$1(null);
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    anonymousClass2.L$3 = function7;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(extractedHash);
                    anonymousClass2.L$6 = doc2;
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(header2);
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(formdata2);
                    anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(response);
                    anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(m3u8);
                    anonymousClass2.L$12 = function8;
                    anonymousClass2.label = 3;
                    AnonymousClass1 anonymousClass6 = anonymousClass2;
                    $result2 = ExtractorApiKt.newExtractorLink(name3, name4, m3u8, extractorLinkType2, aWSStream$getUrl$2$2, anonymousClass6);
                    anonymousClass2 = anonymousClass6;
                    if ($result2 == obj) {
                        return obj;
                    }
                    Map map2 = header2;
                    response2 = response;
                    $this3 = $this2;
                    header3 = map2;
                    function9 = function8;
                    m3u8Url3 = m3u8Url2;
                    formdata3 = formdata2;
                    m3u9 = m3u8;
                    function9.invoke($result2);
                    elementSelectFirst = doc2.selectFirst("script:containsData(function(p,a,c,k,e,d))");
                    if (elementSelectFirst != null) {
                        extractedPack = elementSelectFirst.data();
                    } else {
                        extractedPack = null;
                    }
                    if (extractedPack == null) {
                        extractedPack = "";
                    }
                    unpacked = new JsUnpacker(extractedPack).unpack();
                    if (unpacked != null) {
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(extractedHash);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(m3u8Url3);
                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(header3);
                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(formdata3);
                        anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(response2);
                        anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(m3u9);
                        anonymousClass2.L$12 = SpillingKt.nullOutSpilledVariable(extractedPack);
                        anonymousClass2.L$13 = SpillingKt.nullOutSpilledVariable(unpacked);
                        anonymousClass2.L$14 = SpillingKt.nullOutSpilledVariable(subtitleUrl);
                        anonymousClass2.L$15 = function7;
                        anonymousClass2.label = 4;
                        objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default("English", subtitleUrl, (Function2) null, anonymousClass2, 4, (Object) null);
                        if (objNewSubtitleFile$default == obj) {
                            return obj;
                        }
                        Object obj5 = m3u9;
                        m3u10 = extractedPack;
                        $result = obj5;
                        function10 = function7;
                        subtitleUrl2 = null;
                        url3 = url2;
                        m3u8Url4 = m3u8Url3;
                        header4 = header3;
                        unpacked2 = unpacked;
                        function10.invoke(objNewSubtitleFile$default);
                        header3 = header4;
                        m3u8Url3 = m3u8Url4;
                    }
                }
                return Unit.INSTANCE;
            case 2:
                Map formdata4 = (Map) anonymousClass2.L$9;
                Map header5 = (Map) anonymousClass2.L$8;
                String m3u8Url5 = (String) anonymousClass2.L$7;
                Document doc3 = (Document) anonymousClass2.L$6;
                String extractedHash4 = (String) anonymousClass2.L$5;
                Function1<? super ExtractorLink, Unit> function12 = (Function1) anonymousClass2.L$4;
                Function1<? super SubtitleFile, Unit> function13 = (Function1) anonymousClass2.L$3;
                String referer5 = (String) anonymousClass2.L$2;
                String url5 = (String) anonymousClass2.L$1;
                AWSStream $this5 = (AWSStream) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result2);
                m3u8Url2 = m3u8Url5;
                doc2 = doc3;
                extractedHash = extractedHash4;
                function7 = function13;
                referer2 = referer5;
                url2 = url5;
                formdata2 = formdata4;
                obj = coroutine_suspended;
                header2 = header5;
                function8 = function12;
                objPost$default = $result2;
                $this2 = $this5;
                NiceResponse this_$iv3 = (NiceResponse) objPost$default;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(Response.class));
                response = (Response) safe;
                if (response != null) {
                    String name5 = $this2.getName();
                    String name6 = $this2.getName();
                    ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                    AWSStream$getUrl$2$1 aWSStream$getUrl$2$3 = new AWSStream$getUrl$2$1(null);
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    anonymousClass2.L$3 = function7;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(extractedHash);
                    anonymousClass2.L$6 = doc2;
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(m3u8Url2);
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(header2);
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(formdata2);
                    anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(response);
                    anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(m3u8);
                    anonymousClass2.L$12 = function8;
                    anonymousClass2.label = 3;
                    AnonymousClass1 anonymousClass7 = anonymousClass2;
                    $result2 = ExtractorApiKt.newExtractorLink(name5, name6, m3u8, extractorLinkType3, aWSStream$getUrl$2$3, anonymousClass7);
                    anonymousClass2 = anonymousClass7;
                    if ($result2 == obj) {
                        return obj;
                    }
                    Map map3 = header2;
                    response2 = response;
                    $this3 = $this2;
                    header3 = map3;
                    function9 = function8;
                    m3u8Url3 = m3u8Url2;
                    formdata3 = formdata2;
                    m3u9 = m3u8;
                    function9.invoke($result2);
                    elementSelectFirst = doc2.selectFirst("script:containsData(function(p,a,c,k,e,d))");
                    if (elementSelectFirst != null) {
                        extractedPack = elementSelectFirst.data();
                    } else {
                        extractedPack = null;
                    }
                    if (extractedPack == null) {
                        extractedPack = "";
                    }
                    unpacked = new JsUnpacker(extractedPack).unpack();
                    if (unpacked != null) {
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(extractedHash);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(m3u8Url3);
                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(header3);
                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(formdata3);
                        anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(response2);
                        anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(m3u9);
                        anonymousClass2.L$12 = SpillingKt.nullOutSpilledVariable(extractedPack);
                        anonymousClass2.L$13 = SpillingKt.nullOutSpilledVariable(unpacked);
                        anonymousClass2.L$14 = SpillingKt.nullOutSpilledVariable(subtitleUrl);
                        anonymousClass2.L$15 = function7;
                        anonymousClass2.label = 4;
                        objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default("English", subtitleUrl, (Function2) null, anonymousClass2, 4, (Object) null);
                        if (objNewSubtitleFile$default == obj) {
                            return obj;
                        }
                        Object obj6 = m3u9;
                        m3u10 = extractedPack;
                        $result = obj6;
                        function10 = function7;
                        subtitleUrl2 = null;
                        url3 = url2;
                        m3u8Url4 = m3u8Url3;
                        header4 = header3;
                        unpacked2 = unpacked;
                        function10.invoke(objNewSubtitleFile$default);
                        header3 = header4;
                        m3u8Url3 = m3u8Url4;
                    }
                }
                return Unit.INSTANCE;
            case 3:
                function9 = (Function1) anonymousClass2.L$12;
                m3u9 = (String) anonymousClass2.L$11;
                Response response3 = (Response) anonymousClass2.L$10;
                Map formdata5 = (Map) anonymousClass2.L$9;
                Map header6 = (Map) anonymousClass2.L$8;
                String m3u8Url6 = (String) anonymousClass2.L$7;
                Document doc4 = (Document) anonymousClass2.L$6;
                String extractedHash5 = (String) anonymousClass2.L$5;
                Function1<? super ExtractorLink, Unit> function14 = (Function1) anonymousClass2.L$4;
                Function1<? super SubtitleFile, Unit> function15 = (Function1) anonymousClass2.L$3;
                String referer6 = (String) anonymousClass2.L$2;
                String url6 = (String) anonymousClass2.L$1;
                $this3 = (AWSStream) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result2);
                url2 = url6;
                obj = coroutine_suspended;
                extractedHash = extractedHash5;
                referer2 = referer6;
                header3 = header6;
                m3u8Url3 = m3u8Url6;
                doc2 = doc4;
                function7 = function15;
                formdata3 = formdata5;
                response2 = response3;
                function8 = function14;
                function9.invoke($result2);
                elementSelectFirst = doc2.selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    extractedPack = elementSelectFirst.data();
                } else {
                    extractedPack = null;
                }
                if (extractedPack == null) {
                    extractedPack = "";
                }
                unpacked = new JsUnpacker(extractedPack).unpack();
                if (unpacked != null) {
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(function8);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(extractedHash);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(m3u8Url3);
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(header3);
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(formdata3);
                    anonymousClass2.L$10 = SpillingKt.nullOutSpilledVariable(response2);
                    anonymousClass2.L$11 = SpillingKt.nullOutSpilledVariable(m3u9);
                    anonymousClass2.L$12 = SpillingKt.nullOutSpilledVariable(extractedPack);
                    anonymousClass2.L$13 = SpillingKt.nullOutSpilledVariable(unpacked);
                    anonymousClass2.L$14 = SpillingKt.nullOutSpilledVariable(subtitleUrl);
                    anonymousClass2.L$15 = function7;
                    anonymousClass2.label = 4;
                    objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default("English", subtitleUrl, (Function2) null, anonymousClass2, 4, (Object) null);
                    if (objNewSubtitleFile$default == obj) {
                        return obj;
                    }
                    Object obj7 = m3u9;
                    m3u10 = extractedPack;
                    $result = obj7;
                    function10 = function7;
                    subtitleUrl2 = null;
                    url3 = url2;
                    m3u8Url4 = m3u8Url3;
                    header4 = header3;
                    unpacked2 = unpacked;
                    function10.invoke(objNewSubtitleFile$default);
                    header3 = header4;
                    m3u8Url3 = m3u8Url4;
                }
                return Unit.INSTANCE;
            case 4:
                subtitleUrl2 = null;
                function10 = (Function1) anonymousClass2.L$15;
                unpacked2 = (String) anonymousClass2.L$13;
                m3u10 = (String) anonymousClass2.L$12;
                Object m3u11 = (String) anonymousClass2.L$11;
                response2 = (Response) anonymousClass2.L$10;
                formdata3 = (Map) anonymousClass2.L$9;
                Map header7 = (Map) anonymousClass2.L$8;
                String m3u8Url7 = (String) anonymousClass2.L$7;
                String url7 = (String) anonymousClass2.L$1;
                $this3 = (AWSStream) anonymousClass2.L$0;
                ResultKt.throwOnFailure($result2);
                url3 = url7;
                m3u8Url4 = m3u8Url7;
                $result = m3u11;
                header4 = header7;
                objNewSubtitleFile$default = $result2;
                function10.invoke(objNewSubtitleFile$default);
                header3 = header4;
                m3u8Url3 = m3u8Url4;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J_\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/phisher98/AWSStream$Response;", "", "hls", "", "videoImage", "", "videoSource", "securedLink", "downloadLinks", "", "attachmentLinks", "ck", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getHls", "()Z", "getVideoImage", "()Ljava/lang/String;", "getVideoSource", "getSecuredLink", "getDownloadLinks", "()Ljava/util/List;", "getAttachmentLinks", "getCk", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Response {

        @NotNull
        private final List<Object> attachmentLinks;

        @NotNull
        private final String ck;

        @NotNull
        private final List<Object> downloadLinks;
        private final boolean hls;

        @NotNull
        private final String securedLink;

        @NotNull
        private final String videoImage;

        @NotNull
        private final String videoSource;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, boolean z, String str, String str2, String str3, List list, List list2, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = response.hls;
            }
            if ((i & 2) != 0) {
                str = response.videoImage;
            }
            if ((i & 4) != 0) {
                str2 = response.videoSource;
            }
            if ((i & 8) != 0) {
                str3 = response.securedLink;
            }
            if ((i & 16) != 0) {
                list = response.downloadLinks;
            }
            if ((i & 32) != 0) {
                list2 = response.attachmentLinks;
            }
            if ((i & 64) != 0) {
                str4 = response.ck;
            }
            List list3 = list2;
            String str5 = str4;
            List list4 = list;
            String str6 = str2;
            return response.copy(z, str, str6, str3, list4, list3, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getHls() {
            return this.hls;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getVideoImage() {
            return this.videoImage;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getVideoSource() {
            return this.videoSource;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSecuredLink() {
            return this.securedLink;
        }

        @NotNull
        public final List<Object> component5() {
            return this.downloadLinks;
        }

        @NotNull
        public final List<Object> component6() {
            return this.attachmentLinks;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getCk() {
            return this.ck;
        }

        @NotNull
        public final Response copy(boolean hls, @NotNull String videoImage, @NotNull String videoSource, @NotNull String securedLink, @NotNull List<? extends Object> downloadLinks, @NotNull List<? extends Object> attachmentLinks, @NotNull String ck) {
            return new Response(hls, videoImage, videoSource, securedLink, downloadLinks, attachmentLinks, ck);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.hls == response.hls && Intrinsics.areEqual(this.videoImage, response.videoImage) && Intrinsics.areEqual(this.videoSource, response.videoSource) && Intrinsics.areEqual(this.securedLink, response.securedLink) && Intrinsics.areEqual(this.downloadLinks, response.downloadLinks) && Intrinsics.areEqual(this.attachmentLinks, response.attachmentLinks) && Intrinsics.areEqual(this.ck, response.ck);
        }

        public int hashCode() {
            return (((((((((((AWSStream$Response$$ExternalSyntheticBackport0.m(this.hls) * 31) + this.videoImage.hashCode()) * 31) + this.videoSource.hashCode()) * 31) + this.securedLink.hashCode()) * 31) + this.downloadLinks.hashCode()) * 31) + this.attachmentLinks.hashCode()) * 31) + this.ck.hashCode();
        }

        @NotNull
        public String toString() {
            return "Response(hls=" + this.hls + ", videoImage=" + this.videoImage + ", videoSource=" + this.videoSource + ", securedLink=" + this.securedLink + ", downloadLinks=" + this.downloadLinks + ", attachmentLinks=" + this.attachmentLinks + ", ck=" + this.ck + ")";
        }

        public Response(boolean hls, @NotNull String videoImage, @NotNull String videoSource, @NotNull String securedLink, @NotNull List<? extends Object> list, @NotNull List<? extends Object> list2, @NotNull String ck) {
            this.hls = hls;
            this.videoImage = videoImage;
            this.videoSource = videoSource;
            this.securedLink = securedLink;
            this.downloadLinks = list;
            this.attachmentLinks = list2;
            this.ck = ck;
        }

        public final boolean getHls() {
            return this.hls;
        }

        @NotNull
        public final String getVideoImage() {
            return this.videoImage;
        }

        @NotNull
        public final String getVideoSource() {
            return this.videoSource;
        }

        @NotNull
        public final String getSecuredLink() {
            return this.securedLink;
        }

        @NotNull
        public final List<Object> getDownloadLinks() {
            return this.downloadLinks;
        }

        @NotNull
        public final List<Object> getAttachmentLinks() {
            return this.attachmentLinks;
        }

        @NotNull
        public final String getCk() {
            return this.ck;
        }
    }
}
