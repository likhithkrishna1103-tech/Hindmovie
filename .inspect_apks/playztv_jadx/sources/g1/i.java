package g1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements TextWatcher {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final EditText f4841u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h f4842v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4843w = true;

    public i(EditText editText) {
        this.f4841u = editText;
    }

    public static void a(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            m mVarA = m.a();
            if (editableText == null) {
                length = 0;
            } else {
                mVarA.getClass();
                length = editableText.length();
            }
            mVarA.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i10, int i11) throws Throwable {
        EditText editText = this.f4841u;
        if (editText.isInEditMode() || !this.f4843w || m.f1181k == null || i10 > i11 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = m.a().b();
        if (iB != 0) {
            if (iB == 1) {
                m.a().e((Spannable) charSequence, i, i11 + i);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        m mVarA = m.a();
        if (this.f4842v == null) {
            this.f4842v = new h(editText);
        }
        mVarA.f(this.f4842v);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i10, int i11) {
    }
}
