package com.horis.cloudstreamplugins;

import com.horis.cloudstreamplugins.entities.Source;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: JioHotstarProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.horis.cloudstreamplugins.JioHotstarProvider$loadLinks$2$1$1", f = "JioHotstarProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class JioHotstarProvider$loadLinks$2$1$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ Source $it;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ JioHotstarProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JioHotstarProvider$loadLinks$2$1$1(JioHotstarProvider jioHotstarProvider, Source source, Continuation<? super JioHotstarProvider$loadLinks$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = jioHotstarProvider;
        this.$it = source;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> jioHotstarProvider$loadLinks$2$1$1 = new JioHotstarProvider$loadLinks$2$1$1(this.this$0, this.$it, continuation);
        jioHotstarProvider$loadLinks$2$1$1.L$0 = obj;
        return jioHotstarProvider$loadLinks$2$1$1;
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
                $this$newExtractorLink.setReferer(this.this$0.newUrl + '/');
                $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(StringsKt.substringBefore$default(StringsKt.substringAfter(this.$it.getFile(), "q=", ""), "&in", (String) null, 2, (Object) null)));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
