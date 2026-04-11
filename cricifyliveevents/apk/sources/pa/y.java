package pa;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements TextWatcher {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10139v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ EditText f10140w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f10141x;

    public y(TextInputLayout textInputLayout, EditText editText) {
        this.f10141x = textInputLayout;
        this.f10140w = editText;
        this.f10139v = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.f10141x;
        textInputLayout.w(!textInputLayout.W0, false);
        if (textInputLayout.G) {
            textInputLayout.p(editable);
        }
        if (textInputLayout.O) {
            textInputLayout.x(editable);
        }
        EditText editText = this.f10140w;
        int lineCount = editText.getLineCount();
        int i = this.f10139v;
        if (lineCount != i) {
            if (lineCount < i) {
                int minimumHeight = editText.getMinimumHeight();
                int i10 = textInputLayout.P0;
                if (minimumHeight != i10) {
                    editText.setMinimumHeight(i10);
                }
            }
            this.f10139v = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i10, int i11) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
    }
}
