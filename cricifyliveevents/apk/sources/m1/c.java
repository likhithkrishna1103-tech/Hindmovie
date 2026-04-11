package m1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.m;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends androidx.emoji2.text.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f8023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f8024b;

    public c(TextView textView, d dVar) {
        this.f8023a = new WeakReference(textView);
        this.f8024b = new WeakReference(dVar);
    }

    @Override // androidx.emoji2.text.j
    public final void b() throws Throwable {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.f8023a.get();
        InputFilter inputFilter = (InputFilter) this.f8024b.get();
        if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
            return;
        }
        for (InputFilter inputFilter2 : filters) {
            if (inputFilter2 == inputFilter) {
                if (textView.isAttachedToWindow()) {
                    CharSequence text = textView.getText();
                    m mVarA = m.a();
                    if (text == null) {
                        length = 0;
                    } else {
                        mVarA.getClass();
                        length = text.length();
                    }
                    CharSequence charSequenceE = mVarA.e(text, 0, length);
                    if (text == charSequenceE) {
                        return;
                    }
                    int selectionStart = Selection.getSelectionStart(charSequenceE);
                    int selectionEnd = Selection.getSelectionEnd(charSequenceE);
                    textView.setText(charSequenceE);
                    if (charSequenceE instanceof Spannable) {
                        Spannable spannable = (Spannable) charSequenceE;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                            return;
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                            return;
                        } else {
                            if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }
}
