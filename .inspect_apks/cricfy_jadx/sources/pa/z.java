package pa;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import o.a1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends t0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextInputLayout f10142d;

    public z(TextInputLayout textInputLayout) {
        this.f10142d = textInputLayout;
    }

    @Override // t0.b
    public final void d(View view, u0.e eVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = eVar.f12062a;
        this.f11731a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.f10142d;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean zIsEmpty2 = TextUtils.isEmpty(hint);
        boolean z10 = textInputLayout.Q0;
        boolean zIsEmpty3 = TextUtils.isEmpty(error);
        boolean z11 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String string = !zIsEmpty2 ? hint.toString() : "";
        x xVar = textInputLayout.f2986w;
        a1 a1Var = xVar.f10135w;
        if (a1Var.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(a1Var);
            accessibilityNodeInfo.setTraversalAfter(a1Var);
        } else {
            accessibilityNodeInfo.setTraversalAfter(xVar.f10137y);
        }
        if (!zIsEmpty) {
            eVar.l(text);
        } else if (!TextUtils.isEmpty(string)) {
            eVar.l(string);
            if (!z10 && placeholderText != null) {
                eVar.l(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            eVar.l(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            int i = Build.VERSION.SDK_INT;
            if (i < 26) {
                if (!zIsEmpty) {
                    string = ((Object) text) + ", " + string;
                }
                eVar.l(string);
            } else if (i >= 26) {
                accessibilityNodeInfo.setHintText(string);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", string);
            }
            if (i >= 26) {
                accessibilityNodeInfo.setShowingHintText(zIsEmpty);
            } else {
                eVar.h(4, zIsEmpty);
            }
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z11) {
            if (zIsEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        a1 a1Var2 = textInputLayout.F.f10126y;
        if (a1Var2 != null) {
            accessibilityNodeInfo.setLabelFor(a1Var2);
        }
        textInputLayout.f2988x.b().m(eVar);
    }

    @Override // t0.b
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        this.f10142d.f2988x.b().n(accessibilityEvent);
    }
}
