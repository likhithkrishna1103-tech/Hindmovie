package com.cncverse;

import com.lagradost.cloudstream3.utils.DrmExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LiveEventsProvider.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.LiveEventsProvider$loadLinks$2$1", f = "LiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class LiveEventsProvider$loadLinks$2$1 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $drmKeyBase64;
    final /* synthetic */ String $drmKidBase64;
    final /* synthetic */ Map<String, String> $headers;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LiveEventsProvider$loadLinks$2$1(String str, String str2, Map<String, String> map, Continuation<? super LiveEventsProvider$loadLinks$2$1> continuation) {
        super(2, continuation);
        this.$drmKeyBase64 = str;
        this.$drmKidBase64 = str2;
        this.$headers = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> liveEventsProvider$loadLinks$2$1 = new LiveEventsProvider$loadLinks$2$1(this.$drmKeyBase64, this.$drmKidBase64, this.$headers, continuation);
        liveEventsProvider$loadLinks$2$1.L$0 = obj;
        return liveEventsProvider$loadLinks$2$1;
    }

    public final Object invoke(DrmExtractorLink drmExtractorLink, Continuation<? super Unit> continuation) {
        return create(drmExtractorLink, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DrmExtractorLink $this$newDrmExtractorLink = (DrmExtractorLink) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newDrmExtractorLink.setQuality(Qualities.Unknown.getValue());
                $this$newDrmExtractorLink.setKey(this.$drmKeyBase64);
                $this$newDrmExtractorLink.setKid(this.$drmKidBase64);
                if (!this.$headers.isEmpty()) {
                    $this$newDrmExtractorLink.setHeaders(this.$headers);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
