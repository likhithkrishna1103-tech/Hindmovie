package n;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, v {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c0 f8541v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h.h f8542w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g f8543x;

    @Override // n.v
    public final void c(k kVar, boolean z10) {
        h.h hVar;
        if ((z10 || kVar == this.f8541v) && (hVar = this.f8542w) != null) {
            hVar.dismiss();
        }
    }

    @Override // n.v
    public final boolean n(k kVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        c0 c0Var = this.f8541v;
        g gVar = this.f8543x;
        if (gVar.B == null) {
            gVar.B = new f(gVar);
        }
        c0Var.q(gVar.B.getItem(i), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f8543x.c(this.f8541v, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        c0 c0Var = this.f8541v;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f8542w.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f8542w.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                c0Var.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return c0Var.performShortcut(i, keyEvent, 0);
    }
}
