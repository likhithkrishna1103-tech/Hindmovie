package v9;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements TextWatcher {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13423u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ EditText f13424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f13425w;

    public v(TextInputLayout textInputLayout, EditText editText) {
        this.f13425w = textInputLayout;
        this.f13424v = editText;
        this.f13423u = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.f13425w;
        textInputLayout.u(!textInputLayout.U0, false);
        if (textInputLayout.E) {
            textInputLayout.n(editable);
        }
        if (textInputLayout.M) {
            textInputLayout.v(editable);
        }
        EditText editText = this.f13424v;
        int lineCount = editText.getLineCount();
        int i = this.f13423u;
        if (lineCount != i) {
            if (lineCount < i) {
                WeakHashMap weakHashMap = o0.f10475a;
                int minimumHeight = editText.getMinimumHeight();
                int i10 = textInputLayout.N0;
                if (minimumHeight != i10) {
                    editText.setMinimumHeight(i10);
                }
            }
            this.f13423u = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i10, int i11) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
    }
}
