package androidx.navigation.fragment;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.y;
import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.navigation.p;
import com.google.android.gms.internal.measurement.j4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
class DialogFragmentNavigator$1 implements q {
    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        p pVarG;
        if (mVar == m.ON_STOP) {
            androidx.fragment.app.q qVar = (androidx.fragment.app.q) sVar;
            if (qVar.T().isShowing()) {
                return;
            }
            y yVar = qVar;
            while (true) {
                if (yVar == null) {
                    View view = qVar.f1103b0;
                    if (view != null) {
                        pVarG = j4.g(view);
                    } else {
                        Dialog dialog = qVar.D0;
                        if (dialog == null || dialog.getWindow() == null) {
                            throw new IllegalStateException("Fragment " + qVar + " does not have a NavController set");
                        }
                        pVarG = j4.g(dialog.getWindow().getDecorView());
                    }
                } else if (yVar instanceof e) {
                    pVarG = ((e) yVar).f1344s0;
                    if (pVarG == null) {
                        throw new IllegalStateException("NavController is not available before onCreate()");
                    }
                } else {
                    y yVar2 = yVar.l().f1065x;
                    if (yVar2 instanceof e) {
                        pVarG = ((e) yVar2).f1344s0;
                        if (pVarG == null) {
                            throw new IllegalStateException("NavController is not available before onCreate()");
                        }
                    } else {
                        yVar = yVar.Q;
                    }
                }
            }
            pVarG.e();
        }
    }
}
