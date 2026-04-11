package h0;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0;
import androidx.lifecycle.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends Activity implements androidx.lifecycle.s, t0.j {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final u f5437v = new u(this);

    @Override // t0.j
    public final boolean b(KeyEvent keyEvent) {
        ge.i.e(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ge.i.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        ge.i.d(decorView, "window.decorView");
        if (vf.g.u(decorView, keyEvent)) {
            return true;
        }
        return vf.g.v(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        ge.i.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        ge.i.d(decorView, "window.decorView");
        if (vf.g.u(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = g0.f1156w;
        d0.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        ge.i.e(bundle, "outState");
        this.f5437v.g(androidx.lifecycle.n.f1181x);
        super.onSaveInstanceState(bundle);
    }
}
