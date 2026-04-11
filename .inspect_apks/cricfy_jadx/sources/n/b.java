package n;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.media3.decoder.DecoderInputBuffer;
import o.w1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends w1 {
    public final /* synthetic */ int E = 0;
    public final /* synthetic */ View F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.F = actionMenuItemView;
    }

    @Override // o.w1
    public final a0 b() {
        o.f fVar;
        switch (this.E) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c cVar = ((ActionMenuItemView) this.F).H;
                if (cVar == null || (fVar = ((o.g) cVar).f9225a.P) == null) {
                    return null;
                }
                return fVar.a();
            default:
                o.f fVar2 = ((o.i) this.F).f9241y.O;
                if (fVar2 == null) {
                    return null;
                }
                return fVar2.a();
        }
    }

    @Override // o.w1
    public final boolean c() {
        a0 a0VarB;
        switch (this.E) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.F;
                j jVar = actionMenuItemView.F;
                return jVar != null && jVar.c(actionMenuItemView.C) && (a0VarB = b()) != null && a0VarB.a();
            default:
                ((o.i) this.F).f9241y.n();
                return true;
        }
    }

    @Override // o.w1
    public boolean d() {
        switch (this.E) {
            case 1:
                o.k kVar = ((o.i) this.F).f9241y;
                if (kVar.Q != null) {
                    return false;
                }
                kVar.d();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(o.i iVar, o.i iVar2) {
        super(iVar2);
        this.F = iVar;
    }
}
