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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class n extends Dialog implements androidx.lifecycle.s, x4.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public androidx.lifecycle.u f2189u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bumptech.glide.manager.s f2190v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final nd.i f2191w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final nd.i f2192x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context, int i) {
        super(context, i);
        be.h.e(context, "context");
        this.f2190v = new com.bumptech.glide.manager.s(this);
        final int i10 = 0;
        this.f2191w = new nd.i(new ae.a(this) { // from class: c.m

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ n f2188v;

            {
                this.f2188v = this;
            }

            @Override // ae.a
            public final Object b() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        j4.a aVar = new j4.a();
                        this.f2188v.c().f2157b.d(aVar);
                        return aVar;
                    default:
                        return new c0(new a2.a(8, this.f2188v));
                }
            }
        });
        final int i11 = 1;
        this.f2192x = new nd.i(new ae.a(this) { // from class: c.m

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ n f2188v;

            {
                this.f2188v = this;
            }

            @Override // ae.a
            public final Object b() {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        j4.a aVar = new j4.a();
                        this.f2188v.c().f2157b.d(aVar);
                        return aVar;
                    default:
                        return new c0(new a2.a(8, this.f2188v));
                }
            }
        });
    }

    public static void b(n nVar) {
        super.onBackPressed();
    }

    @Override // x4.d
    public final n.s a() {
        return (n.s) this.f2190v.f2861v;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        be.h.e(view, "view");
        d();
        super.addContentView(view, layoutParams);
    }

    public final c0 c() {
        return (c0) this.f2192x.getValue();
    }

    public final void d() {
        Window window = getWindow();
        be.h.b(window);
        View decorView = window.getDecorView();
        be.h.d(decorView, "getDecorView(...)");
        decorView.setTag(m1.a.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        be.h.b(window2);
        View decorView2 = window2.getDecorView();
        be.h.d(decorView2, "getDecorView(...)");
        decorView2.setTag(d0.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        be.h.b(window3);
        View decorView3 = window3.getDecorView();
        be.h.d(decorView3, "getDecorView(...)");
        decorView3.setTag(x4.a.view_tree_saved_state_registry_owner, this);
        Window window4 = getWindow();
        be.h.b(window4);
        View decorView4 = window4.getDecorView();
        be.h.d(decorView4, "getDecorView(...)");
        decorView4.setTag(j4.j.view_tree_navigation_event_dispatcher_owner, this);
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        androidx.lifecycle.u uVar = this.f2189u;
        if (uVar != null) {
            return uVar;
        }
        androidx.lifecycle.u uVar2 = new androidx.lifecycle.u(this);
        this.f2189u = uVar2;
        return uVar2;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        ((j4.a) this.f2191w.getValue()).a();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            c0 c0VarC = c();
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            be.h.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            c0VarC.b(onBackInvokedDispatcher);
        }
        this.f2190v.g(bundle);
        androidx.lifecycle.u uVar = this.f2189u;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f2189u = uVar;
        }
        uVar.d(androidx.lifecycle.m.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        be.h.d(bundleOnSaveInstanceState, "onSaveInstanceState(...)");
        this.f2190v.h(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        androidx.lifecycle.u uVar = this.f2189u;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f2189u = uVar;
        }
        uVar.d(androidx.lifecycle.m.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        androidx.lifecycle.u uVar = this.f2189u;
        if (uVar == null) {
            uVar = new androidx.lifecycle.u(this);
            this.f2189u = uVar;
        }
        uVar.d(androidx.lifecycle.m.ON_DESTROY);
        this.f2189u = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        d();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        be.h.e(view, "view");
        d();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        be.h.e(view, "view");
        d();
        super.setContentView(view, layoutParams);
    }
}
