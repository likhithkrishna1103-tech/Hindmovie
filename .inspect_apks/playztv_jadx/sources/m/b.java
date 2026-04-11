package m;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.media3.decoder.DecoderInputBuffer;
import n.w1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends w1 {
    public final /* synthetic */ int D = 0;
    public final /* synthetic */ View E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.E = actionMenuItemView;
    }

    @Override // n.w1
    public final a0 b() {
        n.f fVar;
        switch (this.D) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c cVar = ((ActionMenuItemView) this.E).G;
                if (cVar == null || (fVar = ((n.g) cVar).f8389a.O) == null) {
                    return null;
                }
                return fVar.a();
            default:
                n.f fVar2 = ((n.i) this.E).f8399x.N;
                if (fVar2 == null) {
                    return null;
                }
                return fVar2.a();
        }
    }

    @Override // n.w1
    public final boolean c() {
        a0 a0VarB;
        switch (this.D) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.E;
                j jVar = actionMenuItemView.E;
                return jVar != null && jVar.c(actionMenuItemView.B) && (a0VarB = b()) != null && a0VarB.a();
            default:
                ((n.i) this.E).f8399x.n();
                return true;
        }
    }

    @Override // n.w1
    public boolean d() {
        switch (this.D) {
            case 1:
                n.k kVar = ((n.i) this.E).f8399x;
                if (kVar.P != null) {
                    return false;
                }
                kVar.d();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n.i iVar, n.i iVar2) {
        super(iVar2);
        this.E = iVar;
    }
}
