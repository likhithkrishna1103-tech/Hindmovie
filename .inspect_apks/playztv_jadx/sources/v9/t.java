package v9;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13415e;
    public EditText f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.material.datepicker.n f13416g;

    public t(m mVar, int i) {
        super(mVar);
        this.f13415e = p8.e.design_password_eye;
        this.f13416g = new com.google.android.material.datepicker.n(14, this);
        if (i != 0) {
            this.f13415e = i;
        }
    }

    @Override // v9.n
    public final void b() {
        p();
    }

    @Override // v9.n
    public final int c() {
        return p8.j.password_toggle_content_description;
    }

    @Override // v9.n
    public final int d() {
        return this.f13415e;
    }

    @Override // v9.n
    public final View.OnClickListener f() {
        return this.f13416g;
    }

    @Override // v9.n
    public final boolean j() {
        return true;
    }

    @Override // v9.n
    public final boolean k() {
        EditText editText = this.f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // v9.n
    public final void l(EditText editText) {
        this.f = editText;
        p();
    }

    @Override // v9.n
    public final void q() {
        EditText editText = this.f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // v9.n
    public final void r() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
