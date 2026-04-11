package o;

import android.content.Context;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends n.u {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9205l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k f9206m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(k kVar, Context context, n.k kVar2, View view) {
        super(context, kVar2, view, true, g.a.actionOverflowMenuStyle, 0);
        this.f9206m = kVar;
        this.f = 8388613;
        kf.i iVar = kVar.S;
        this.f8586h = iVar;
        n.s sVar = this.i;
        if (sVar != null) {
            sVar.l(iVar);
        }
    }

    @Override // n.u
    public final void c() {
        switch (this.f9205l) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = this.f9206m;
                kVar.P = null;
                kVar.T = 0;
                super.c();
                break;
            default:
                k kVar2 = this.f9206m;
                n.k kVar3 = kVar2.f9251x;
                if (kVar3 != null) {
                    kVar3.c(true);
                }
                kVar2.O = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(k kVar, Context context, n.c0 c0Var, View view) {
        super(context, c0Var, view, false, g.a.actionOverflowMenuStyle, 0);
        this.f9206m = kVar;
        if ((c0Var.A.f8565x & 32) != 32) {
            View view2 = kVar.E;
            this.f8584e = view2 == null ? (View) kVar.C : view2;
        }
        kf.i iVar = kVar.S;
        this.f8586h = iVar;
        n.s sVar = this.i;
        if (sVar != null) {
            sVar.l(iVar);
        }
    }
}
