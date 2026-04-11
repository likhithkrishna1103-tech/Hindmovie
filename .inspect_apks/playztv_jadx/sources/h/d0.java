package h;

import android.R;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class d0 extends c.n implements k {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b0 f5459y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c0 f5460z;

    /* JADX WARN: Type inference failed for: r1v2, types: [h.c0] */
    public d0(ContextThemeWrapper contextThemeWrapper, int i) {
        int i10;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(g.a.dialogTheme, typedValue, true);
            i10 = typedValue.resourceId;
        } else {
            i10 = i;
        }
        super(contextThemeWrapper, i10);
        this.f5460z = new q0.k() { // from class: h.c0
            @Override // q0.k
            public final boolean b(KeyEvent keyEvent) {
                return this.f5458u.g(keyEvent);
            }
        };
        q qVarE = e();
        if (i == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(g.a.dialogTheme, typedValue2, true);
            i = typedValue2.resourceId;
        }
        ((b0) qVarE).f5428o0 = i;
        qVarE.d();
    }

    @Override // c.n, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        b0 b0Var = (b0) e();
        b0Var.x();
        ((ViewGroup) b0Var.V.findViewById(R.id.content)).addView(view, layoutParams);
        b0Var.G.a(b0Var.F.getCallback());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        e().e();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return q1.c.y(this.f5460z, getWindow().getDecorView(), this, keyEvent);
    }

    public final q e() {
        if (this.f5459y == null) {
            o oVar = q.f5550u;
            this.f5459y = new b0(getContext(), getWindow(), this, this);
        }
        return this.f5459y;
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        b0 b0Var = (b0) e();
        b0Var.x();
        return b0Var.F.findViewById(i);
    }

    public final boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        e().b();
    }

    @Override // c.n, android.app.Dialog
    public void onCreate(Bundle bundle) {
        e().a();
        super.onCreate(bundle);
        e().d();
    }

    @Override // c.n, android.app.Dialog
    public final void onStop() {
        super.onStop();
        b0 b0Var = (b0) e();
        b0Var.D();
        com.bumptech.glide.d dVar = b0Var.I;
        if (dVar != null) {
            dVar.O(false);
        }
    }

    @Override // c.n, android.app.Dialog
    public final void setContentView(int i) {
        d();
        e().i(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().m(charSequence);
    }

    @Override // c.n, android.app.Dialog
    public final void setContentView(View view) {
        d();
        e().j(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        e().m(getContext().getString(i));
    }

    @Override // c.n, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        e().k(view, layoutParams);
    }
}
