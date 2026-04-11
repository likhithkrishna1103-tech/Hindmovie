package n;

import android.content.Context;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends m.u {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f8378l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k f8379m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(k kVar, Context context, m.k kVar2, View view) {
        super(context, kVar2, view, true, g.a.actionOverflowMenuStyle, 0);
        this.f8379m = kVar;
        this.f = 8388613;
        wb.c cVar = kVar.R;
        this.f8272h = cVar;
        m.s sVar = this.i;
        if (sVar != null) {
            sVar.l(cVar);
        }
    }

    @Override // m.u
    public final void c() {
        switch (this.f8378l) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = this.f8379m;
                kVar.O = null;
                kVar.S = 0;
                super.c();
                break;
            default:
                k kVar2 = this.f8379m;
                m.k kVar3 = kVar2.f8423w;
                if (kVar3 != null) {
                    kVar3.c(true);
                }
                kVar2.N = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(k kVar, Context context, m.c0 c0Var, View view) {
        super(context, c0Var, view, false, g.a.actionOverflowMenuStyle, 0);
        this.f8379m = kVar;
        if ((c0Var.A.f8251x & 32) != 32) {
            View view2 = kVar.D;
            this.f8270e = view2 == null ? (View) kVar.B : view2;
        }
        wb.c cVar = kVar.R;
        this.f8272h = cVar;
        m.s sVar = this.i;
        if (sVar != null) {
            sVar.l(cVar);
        }
    }
}
