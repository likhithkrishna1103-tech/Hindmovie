package v9;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import n.d1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends q0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextInputLayout f13426d;

    public w(TextInputLayout textInputLayout) {
        this.f13426d = textInputLayout;
    }

    @Override // q0.b
    public final void d(View view, r0.e eVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = eVar.f11226a;
        this.f10418a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.f13426d;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean zIsEmpty2 = TextUtils.isEmpty(hint);
        boolean z2 = textInputLayout.O0;
        boolean zIsEmpty3 = TextUtils.isEmpty(error);
        boolean z10 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String string = !zIsEmpty2 ? hint.toString() : "";
        u uVar = textInputLayout.f3521v;
        d1 d1Var = uVar.f13418v;
        if (d1Var.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(d1Var);
            accessibilityNodeInfo.setTraversalAfter(d1Var);
        } else {
            accessibilityNodeInfo.setTraversalAfter(uVar.f13420x);
        }
        if (!zIsEmpty) {
            eVar.m(text);
        } else if (!TextUtils.isEmpty(string)) {
            eVar.m(string);
            if (!z2 && placeholderText != null) {
                eVar.m(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            eVar.m(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                eVar.k(string);
            } else {
                if (!zIsEmpty) {
                    string = ((Object) text) + ", " + string;
                }
                eVar.m(string);
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
        if (z10) {
            if (zIsEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        d1 d1Var2 = textInputLayout.D.f13408y;
        if (d1Var2 != null) {
            accessibilityNodeInfo.setLabelFor(d1Var2);
        }
        textInputLayout.f3523w.b().m(eVar);
    }

    @Override // q0.b
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        this.f13426d.f3523w.b().n(accessibilityEvent);
    }
}
