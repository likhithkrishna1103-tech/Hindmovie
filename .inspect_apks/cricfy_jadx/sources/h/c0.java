package h;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends c.o implements k {
    public final b0 A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a0 f5308z;

    /* JADX WARN: Type inference failed for: r1v2, types: [h.b0] */
    public c0(Context context, int i) {
        int i10;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(g.a.dialogTheme, typedValue, true);
            i10 = typedValue.resourceId;
        } else {
            i10 = i;
        }
        super(context, i10);
        this.A = new t0.j() { // from class: h.b0
            @Override // t0.j
            public final boolean b(KeyEvent keyEvent) {
                return this.f5289v.g(keyEvent);
            }
        };
        p pVarE = e();
        if (i == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(g.a.dialogTheme, typedValue2, true);
            i = typedValue2.resourceId;
        }
        ((a0) pVarE).o0 = i;
        pVarE.d();
    }

    @Override // c.o, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        a0 a0Var = (a0) e();
        a0Var.v();
        ((ViewGroup) a0Var.V.findViewById(R.id.content)).addView(view, layoutParams);
        a0Var.H.a(a0Var.G.getCallback());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        e().e();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return vf.g.v(this.A, getWindow().getDecorView(), this, keyEvent);
    }

    public final p e() {
        if (this.f5308z == null) {
            o oVar = p.f5394v;
            this.f5308z = new a0(getContext(), getWindow(), this, this);
        }
        return this.f5308z;
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        a0 a0Var = (a0) e();
        a0Var.v();
        return a0Var.G.findViewById(i);
    }

    public final boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        e().b();
    }

    @Override // c.o, android.app.Dialog
    public void onCreate(Bundle bundle) {
        e().a();
        super.onCreate(bundle);
        e().d();
    }

    @Override // c.o, android.app.Dialog
    public final void onStop() {
        super.onStop();
        a0 a0Var = (a0) e();
        a0Var.D();
        vf.g gVar = a0Var.J;
        if (gVar != null) {
            gVar.V(false);
        }
    }

    @Override // c.o, android.app.Dialog
    public final void setContentView(int i) {
        d();
        e().h(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().l(charSequence);
    }

    @Override // c.o, android.app.Dialog
    public final void setContentView(View view) {
        d();
        e().i(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        e().l(getContext().getString(i));
    }

    @Override // c.o, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        e().j(view, layoutParams);
    }
}
