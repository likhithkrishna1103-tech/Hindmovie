package c;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class o extends Dialog implements androidx.lifecycle.s, b5.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public androidx.lifecycle.u f1981v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bumptech.glide.manager.u f1982w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final rd.j f1983x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final rd.j f1984y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context, int i) {
        super(context, i);
        ge.i.e(context, "context");
        this.f1982w = new com.bumptech.glide.manager.u(this);
        final int i10 = 0;
        this.f1983x = new rd.j(new fe.a(this) { // from class: c.n

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ o f1980w;

            {
                this.f1980w = this;
            }

            @Override // fe.a
            public final Object b() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        o4.a aVar = new o4.a();
                        this.f1980w.c().b().f1947c.b(aVar);
                        return aVar;
                    default:
                        return new f0(new androidx.emoji2.text.w(4, this.f1980w));
                }
            }
        });
        final int i11 = 1;
        this.f1984y = new rd.j(new fe.a(this) { // from class: c.n

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ o f1980w;

            {
                this.f1980w = this;
            }

            @Override // fe.a
            public final Object b() {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        o4.a aVar = new o4.a();
                        this.f1980w.c().b().f1947c.b(aVar);
                        return aVar;
                    default:
                        return new f0(new androidx.emoji2.text.w(4, this.f1980w));
                }
            }
        });
    }

    public static void b(o oVar) {
        super.onBackPressed();
    }

    @Override // b5.f
    public final b5.e a() {
        return (b5.e) this.f1982w.f2291x;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ge.i.e(view, "view");
        d();
        super.addContentView(view, layoutParams);
    }

    public final f0 c() {
        return (f0) this.f1984y.getValue();
    }

    public final void d() {
        Window window = getWindow();
        ge.i.b(window);
        View decorView = window.getDecorView();
        ge.i.d(decorView, "getDecorView(...)");
        decorView.setTag(s1.a.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        ge.i.b(window2);
        View decorView2 = window2.getDecorView();
        ge.i.d(decorView2, "getDecorView(...)");
        decorView2.setTag(g0.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        ge.i.b(window3);
        View decorView3 = window3.getDecorView();
        ge.i.d(decorView3, "getDecorView(...)");
        decorView3.setTag(b5.a.view_tree_saved_state_registry_owner, this);
        Window window4 = getWindow();
        ge.i.b(window4);
        View decorView4 = window4.getDecorView();
        ge.i.d(decorView4, "getDecorView(...)");
        decorView4.setTag(o4.j.view_tree_navigation_event_dispatcher_owner, this);
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        androidx.lifecycle.u uVar = this.f1981v;
        if (uVar != null) {
            return uVar;
        }
        androidx.lifecycle.u uVar2 = new androidx.lifecycle.u(this);
        this.f1981v = uVar2;
        return uVar2;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        ((o4.a) this.f1983x.getValue()).a();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            f0 f0VarC = c();
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            ge.i.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            f0VarC.c(onBackInvokedDispatcher);
        }
        this.f1982w.e(bundle);
        androidx.lifecycle.u uVar = this.f1981v;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f1981v = uVar;
        }
        uVar.d(androidx.lifecycle.m.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        ge.i.d(bundleOnSaveInstanceState, "onSaveInstanceState(...)");
        this.f1982w.f(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        androidx.lifecycle.u uVar = this.f1981v;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f1981v = uVar;
        }
        uVar.d(androidx.lifecycle.m.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        androidx.lifecycle.u uVar = this.f1981v;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f1981v = uVar;
        }
        uVar.d(androidx.lifecycle.m.ON_DESTROY);
        this.f1981v = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        d();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        ge.i.e(view, "view");
        d();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ge.i.e(view, "view");
        d();
        super.setContentView(view, layoutParams);
    }
}
