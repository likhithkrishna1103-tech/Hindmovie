package e0;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0;
import androidx.lifecycle.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends Activity implements androidx.lifecycle.s, q0.k {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final u f4244u = new u(this);

    @Override // q0.k
    public final boolean b(KeyEvent keyEvent) {
        be.h.e(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        be.h.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        be.h.d(decorView, "window.decorView");
        if (q1.c.x(decorView, keyEvent)) {
            return true;
        }
        return q1.c.y(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        be.h.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        be.h.d(decorView, "window.decorView");
        if (q1.c.x(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = g0.f1459v;
        d0.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        be.h.e(bundle, "outState");
        this.f4244u.g();
        super.onSaveInstanceState(bundle);
    }
}
