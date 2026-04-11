package pa;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10132e;
    public EditText f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.material.datepicker.n f10133g;

    public w(p pVar, int i) {
        super(pVar);
        this.f10132e = k9.e.design_password_eye;
        this.f10133g = new com.google.android.material.datepicker.n(8, this);
        if (i != 0) {
            this.f10132e = i;
        }
    }

    @Override // pa.q
    public final void b() {
        p();
    }

    @Override // pa.q
    public final int c() {
        return k9.j.password_toggle_content_description;
    }

    @Override // pa.q
    public final int d() {
        return this.f10132e;
    }

    @Override // pa.q
    public final View.OnClickListener f() {
        return this.f10133g;
    }

    @Override // pa.q
    public final boolean j() {
        return true;
    }

    @Override // pa.q
    public final boolean k() {
        EditText editText = this.f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // pa.q
    public final void l(EditText editText) {
        this.f = editText;
        p();
    }

    @Override // pa.q
    public final void q() {
        EditText editText = this.f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // pa.q
    public final void r() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
