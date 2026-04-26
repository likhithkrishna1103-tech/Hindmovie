package com.horis.cloudstreamplugins;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NetflixProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.horis.cloudstreamplugins.NetflixProvider$loadLinks$2$1$1", f = "NetflixProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class NetflixProvider$loadLinks$2$1$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetflixProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetflixProvider$loadLinks$2$1$1(NetflixProvider netflixProvider, Continuation<? super NetflixProvider$loadLinks$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = netflixProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> netflixProvider$loadLinks$2$1$1 = new NetflixProvider$loadLinks$2$1$1(this.this$0, continuation);
        netflixProvider$loadLinks$2$1$1.L$0 = obj;
        return netflixProvider$loadLinks$2$1$1;
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
                $this$newExtractorLink.setReferer(this.this$0.getMainUrl() + '/');
                $this$newExtractorLink.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Android) ExoPlayer"), TuplesKt.to("Accept", "*/*"), TuplesKt.to("Accept-Encoding", "identity"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("Cookie", "hd=on")}));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
