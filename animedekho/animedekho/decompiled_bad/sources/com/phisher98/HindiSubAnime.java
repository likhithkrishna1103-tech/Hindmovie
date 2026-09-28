package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: HindiSubAnime.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0\u001dH\u0096@¢\u0006\u0002\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/phisher98/HindiSubAnime;", "Lcom/phisher98/AnimeDekhoProvider;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHindiSubAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HindiSubAnime.kt\ncom/phisher98/HindiSubAnime\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,46:1\n63#2:47\n64#2,15:49\n1#3:48\n50#4:64\n43#4:65\n*S KotlinDebug\n*F\n+ 1 HindiSubAnime.kt\ncom/phisher98/HindiSubAnime\n*L\n33#1:47\n33#1:49,15\n33#1:48\n33#1:64\n33#1:65\n*E\n"})
public final class HindiSubAnime extends AnimeDekhoProvider {

    @NotNull
    private String mainUrl = "https://hindisubanime.co";

    @NotNull
    private String name = "HindiSubAnime";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("/category/shounen/", "Shounen"), TuplesKt.to("/category/action/", "Action"), TuplesKt.to("/category/fantasy/", "Fantasy"), TuplesKt.to("/serie/", "Series")});

    /* JADX INFO: renamed from: com.phisher98.HindiSubAnime$loadLinks$1, reason: invalid class name */
    /* JADX INFO: compiled from: HindiSubAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.HindiSubAnime", f = "HindiSubAnime.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {34, 37}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "media", "isCasting", "data", "subtitleCallback", "callback", "media", "body", "term", "isCasting"}, nl = {35, 44}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return HindiSubAnime.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    @Override // com.phisher98.AnimeDekhoProvider
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.phisher98.AnimeDekhoProvider
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.phisher98.AnimeDekhoProvider
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.phisher98.AnimeDekhoProvider
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.phisher98.AnimeDekhoProvider
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.phisher98.AnimeDekhoProvider
    @NotNull
    public String getLang() {
        return this.lang;
    }

    @Override // com.phisher98.AnimeDekhoProvider
    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @Override // com.phisher98.AnimeDekhoProvider
    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.phisher98.AnimeDekhoProvider
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws ErrorLoadingException {
        AnonymousClass1 anonymousClass1;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        Object obj3;
        int i;
        AnonymousClass1 anonymousClass2;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        AnimeDekhoProvider.Media media;
        boolean isCasting2;
        Element elementSelectFirst;
        String body;
        List groupValues;
        boolean z;
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
        AnonymousClass1 anonymousClass3 = anonymousClass1;
        Object $result = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass3.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(AnimeDekhoProvider.Media.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimeDekhoProvider.Media.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<AnimeDekhoProvider.Media>() { // from class: com.phisher98.HindiSubAnime$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<AnimeDekhoProvider.Media>() { // from class: com.phisher98.HindiSubAnime$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<AnimeDekhoProvider.Media>() { // from class: com.phisher98.HindiSubAnime$loadLinks$$inlined$parseJson$1
                    });
                }
                AnimeDekhoProvider.Media media2 = (AnimeDekhoProvider.Media) objDecodeFromString;
                Requests app = MainActivityKt.getApp();
                String url = media2.getUrl();
                anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(data);
                anonymousClass3.L$1 = function1;
                anonymousClass3.L$2 = function2;
                anonymousClass3.L$3 = media2;
                anonymousClass3.Z$0 = isCasting;
                anonymousClass3.label = 1;
                obj2 = coroutine_suspended;
                obj3 = null;
                i = 2;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass3, 4094, (Object) null);
                anonymousClass2 = anonymousClass3;
                if ($result == obj2) {
                    return obj2;
                }
                data2 = data;
                function3 = function1;
                function4 = function2;
                media = media2;
                isCasting2 = isCasting;
                elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                if (elementSelectFirst != null || (body = elementSelectFirst.attr("class")) == null) {
                    return Boxing.boxBoolean(false);
                }
                MatchResult matchResultFind$default = Regex.find$default(new Regex("(?:term|postid)-(\\d+)"), body, 0, i, obj3);
                if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                    z = true;
                    String term = (String) groupValues.get(1);
                    if (term != null) {
                        List list = CollectionsKt.toList(new IntRange(0, 4));
                        Object obj4 = obj2;
                        AnonymousClass2 anonymousClass4 = new AnonymousClass2(term, media, function3, function4, null);
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(media);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(body);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(term);
                        anonymousClass2.Z$0 = isCasting2;
                        anonymousClass2.label = i;
                        return ParCollectionsKt.amap(list, anonymousClass4, anonymousClass2) == obj4 ? obj4 : Boxing.boxBoolean(z);
                    }
                }
                throw new ErrorLoadingException("no id found");
            case 1:
                isCasting2 = anonymousClass3.Z$0;
                AnimeDekhoProvider.Media media3 = (AnimeDekhoProvider.Media) anonymousClass3.L$3;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) anonymousClass3.L$2;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) anonymousClass3.L$1;
                data2 = (String) anonymousClass3.L$0;
                ResultKt.throwOnFailure($result);
                anonymousClass2 = anonymousClass3;
                obj2 = coroutine_suspended;
                media = media3;
                obj3 = null;
                function4 = function5;
                function3 = function6;
                i = 2;
                elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                if (elementSelectFirst != null) {
                    break;
                }
                return Boxing.boxBoolean(false);
            case 2:
                boolean z2 = anonymousClass3.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.HindiSubAnime$loadLinks$2, reason: invalid class name */
    /* JADX INFO: compiled from: HindiSubAnime.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "i", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.HindiSubAnime$loadLinks$2", f = "HindiSubAnime.kt", i = {0, 1, 1}, l = {38, 42}, m = "invokeSuspend", n = {"i", "link", "i"}, nl = {39, 43}, s = {"I$0", "L$0", "I$0"}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ AnimeDekhoProvider.Media $media;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $term;
        /* synthetic */ int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, AnimeDekhoProvider.Media media, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$term = str;
            this.$media = media;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = HindiSubAnime.this.new AnonymousClass2(this.$term, this.$media, this.$subtitleCallback, this.$callback, continuation);
            anonymousClass2.I$0 = ((Number) obj).intValue();
            return anonymousClass2;
        }

        public final Object invoke(int i, Continuation<? super Unit> continuation) {
            return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) obj2);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Element elementSelectFirst;
            String link;
            int i = this.I$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Requests app = MainActivityKt.getApp();
                    String mainUrl = HindiSubAnime.this.getMainUrl();
                    String str = this.$term;
                    Integer mediaType = this.$media.getMediaType();
                    this.I$0 = i;
                    this.label = 1;
                    obj = Requests.get$default(app, mainUrl + "/?trdekho=" + i + "&trid=" + str + "&trtype=" + mediaType, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("iframe");
                    if (elementSelectFirst != null || (link = elementSelectFirst.attr("src")) == null) {
                        return Unit.INSTANCE;
                    }
                    Log.INSTANCE.d("Phisher", link);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(link);
                    this.I$0 = i;
                    this.label = 2;
                    if (ExtractorApiKt.loadExtractor(link, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("iframe");
                    if (elementSelectFirst != null) {
                        break;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
