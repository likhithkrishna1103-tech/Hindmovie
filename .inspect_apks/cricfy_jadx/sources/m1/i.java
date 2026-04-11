package m1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements TextWatcher {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final EditText f8034v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f8035w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f8036x = true;

    public i(EditText editText) {
        this.f8034v = editText;
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
        EditText editText = this.f8034v;
        if (editText.isInEditMode() || !this.f8036x || m.f863k == null || i10 > i11 || !(charSequence instanceof Spannable)) {
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
        if (this.f8035w == null) {
            this.f8035w = new h(editText);
        }
        mVarA.f(this.f8035w);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i10, int i11) {
    }
}
