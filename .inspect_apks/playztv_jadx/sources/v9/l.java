package v9;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f13369a;

    public l(m mVar) {
        this.f13369a = mVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        m mVar = this.f13369a;
        k kVar = mVar.P;
        if (mVar.M == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = mVar.M;
        if (editText != null) {
            editText.removeTextChangedListener(kVar);
            if (mVar.M.getOnFocusChangeListener() == mVar.b().e()) {
                mVar.M.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        mVar.M = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(kVar);
        }
        mVar.b().l(mVar.M);
        mVar.j(mVar.b());
    }
}
