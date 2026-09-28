package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/phisher98/GDMirrorbot;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/GDMirrorbot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,448:1\n1#2:449\n1#2:453\n1#2:476\n1#2:497\n93#3,2:450\n63#3:452\n64#3,15:454\n95#3,2:471\n93#3,2:473\n63#3:475\n64#3,15:477\n95#3,2:494\n63#3:496\n64#3,15:498\n50#4:469\n43#4:470\n50#4:492\n43#4:493\n50#4:513\n43#4:514\n2068#5,2:515\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/GDMirrorbot\n*L\n72#1:453\n84#1:476\n93#1:497\n72#1:450,2\n72#1:452\n72#1:454,15\n72#1:471,2\n84#1:473,2\n84#1:475\n84#1:477,15\n84#1:494,2\n93#1:496\n93#1:498,15\n72#1:469\n72#1:470\n84#1:492\n84#1:493\n93#1:513\n93#1:514\n101#1:515,2\n*E\n"})
public class GDMirrorbot extends ExtractorApi {

    @NotNull
    private String name = "GDMirrorbot";

    @NotNull
    private String mainUrl = "https://gdmirrorbot.nl";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.GDMirrorbot$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.GDMirrorbot", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {52, 54, 69, 82, 110, 111, 112}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "pageText", "finalId", "myKey", "idType", "baseUrl", "hostUrl", "apiUrl", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "root", "siteUrls", "siteFriendlyNames", "mresultData", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "root", "siteUrls", "siteFriendlyNames", "mresultData", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "root", "siteUrls", "siteFriendlyNames", "mresultData", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base"}, nl = {54, 55, 72, 84, 111, 112, 114}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
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
            return GDMirrorbot.getUrl$suspendImpl(GDMirrorbot.this, null, null, null, null, (Continuation) this);
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

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:295:0x0a1b  */
    /* JADX WARN: Code duplicated, block: B:297:0x0a2d  */
    /* JADX WARN: Code duplicated, block: B:346:0x0ba4 A[Catch: Exception -> 0x0d33, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x0d33, blocks: (B:325:0x0acb, B:327:0x0ad7, B:330:0x0ae7, B:346:0x0ba4), top: B:405:0x0acb }] */
    /* JADX WARN: Code duplicated, block: B:351:0x0c24 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:352:0x0c25  */
    /* JADX WARN: Code duplicated, block: B:382:0x0e00  */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0229: MOVE (r11 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('friendlyName' java.lang.Object)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0204: MOVE (r0 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY] A[D('fullUrl' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0221: MOVE (r24 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('mresultData' java.lang.Object)]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-forEach-GDMirrorbot$getUrl$2' int)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0213: MOVE (r28 I:??[OBJECT, ARRAY] A[D('responseText' java.lang.String)]) = (r15 I:??[OBJECT, ARRAY] A[D('base' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x0215: MOVE (r15 I:??[OBJECT, ARRAY] A[D('base' java.lang.String)]) = (r18 I:??[OBJECT, ARRAY] A[D('path' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x0223: MOVE (r31 I:??[OBJECT, ARRAY] A[D('sid' java.lang.String)]) = (r19 I:??[OBJECT, ARRAY] A[D('key' java.lang.Object)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x022a: MOVE (r5 I:??[OBJECT, ARRAY] A[D('$this' com.phisher98.GDMirrorbot)]) = (r20 I:??[OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x0217: MOVE (r7 I:??[OBJECT, ARRAY] A[D('$result' java.lang.Object)]) = (r21 I:??[OBJECT, ARRAY]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x022e: MOVE (r25 I:??[OBJECT, ARRAY] A[D('siteFriendlyNames' java.util.Map)]) = (r22 I:??[OBJECT, ARRAY] A[D('$this$forEach$iv' java.lang.Iterable)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x0219: MOVE (r10 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY] A[D('decodedMresult' java.util.Map)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 24, insn: 0x021b: MOVE (r23 I:??[OBJECT, ARRAY] A[D('decodedMresult' java.util.Map)]) = (r24 I:??[OBJECT, ARRAY] A[D('mresultData' java.lang.Object)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x022c: MOVE (r12 I:??[OBJECT, ARRAY] A[D('friendlyName' java.lang.Object)]) = (r25 I:??[OBJECT, ARRAY] A[D('siteFriendlyNames' java.util.Map)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x0205: MOVE (r13 I:??[OBJECT, ARRAY] A[D('fullUrl' java.lang.String)]) = (r26 I:??[OBJECT, ARRAY] A[D('siteUrls' java.util.Map)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x0209: MOVE (r16 I:??[OBJECT, ARRAY]) = (r29 I:??[OBJECT, ARRAY] A[D('postData' java.util.Map)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x020b: MOVE (r26 I:??[OBJECT, ARRAY] A[D('siteUrls' java.util.Map)]) = (r30 I:??[OBJECT, ARRAY] A[D('host' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Not initialized variable reg: 31, insn: 0x021d: MOVE (r18 I:??[OBJECT, ARRAY] A[D('path' java.lang.String)]) = (r31 I:??[OBJECT, ARRAY] A[D('sid' java.lang.String)]), block:B:22:0x0202 */
    /* JADX WARN: Path cross not found for [B:455:0x09ac, B:290:0x09c1], limit reached: 437 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.phisher98.GDMirrorbot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v50 */
    /* JADX WARN: Type inference failed for: r9v54 */
    /* JADX WARN: Type inference failed for: r9v56 */
    /* JADX WARN: Type inference failed for: r9v58 */
    /* JADX WARN: Type inference failed for: r9v59 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v60 */
    /* JADX WARN: Type inference failed for: r9v61 */
    /* JADX WARN: Type inference failed for: r9v62 */
    /* JADX WARN: Type inference failed for: r9v63 */
    /* JADX WARN: Type inference failed for: r9v64 */
    /* JADX WARN: Type inference failed for: r9v65 */
    /* JADX WARN: Type inference failed for: r9v66 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:343:0x0b6f -> B:362:0x0cf2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:379:0x0d85 -> B:380:0x0dd9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:383:0x0e13 -> B:384:0x0e1e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.GDMirrorbot r38, java.lang.String r39, java.lang.String r40, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r41, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r42, kotlin.coroutines.Continuation<? super kotlin.Unit> r43) {
        /*
            Method dump skipped, instruction units count: 3688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.GDMirrorbot.getUrl$suspendImpl(com.phisher98.GDMirrorbot, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getBaseUrl(String url) {
        Url it = URLUtilsKt.Url(url);
        return it.getProtocol().getName() + "://" + it.getHost();
    }
}
