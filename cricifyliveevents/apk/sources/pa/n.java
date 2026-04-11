package pa;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f10084a;

    public n(p pVar) {
        this.f10084a = pVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        p pVar = this.f10084a;
        m mVar = pVar.Q;
        if (pVar.N == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = pVar.N;
        if (editText != null) {
            editText.removeTextChangedListener(mVar);
            if (pVar.N.getOnFocusChangeListener() == pVar.b().e()) {
                pVar.N.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        pVar.N = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(mVar);
        }
        pVar.b().l(pVar.N);
        pVar.j(pVar.b());
    }
}
