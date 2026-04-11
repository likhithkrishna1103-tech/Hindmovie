package v9;

import android.R;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import k9.j;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b1.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Chip f13508q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Chip chip, Chip chip2) {
        super(chip2);
        this.f13508q = chip;
    }

    @Override // b1.b
    public final int n(float f, float f10) {
        int i = Chip.S;
        Chip chip = this.f13508q;
        return (chip.d() && chip.getCloseIconTouchBounds().contains(f, f10)) ? 1 : 0;
    }

    @Override // b1.b
    public final void o(ArrayList arrayList) {
        c cVar;
        arrayList.add(0);
        int i = Chip.S;
        Chip chip = this.f13508q;
        if (!chip.d() || (cVar = chip.f2837z) == null || !cVar.f13532p0 || chip.C == null) {
            return;
        }
        arrayList.add(1);
    }

    @Override // b1.b
    public final boolean r(int i, int i10) {
        boolean z10 = false;
        if (i10 == 16) {
            Chip chip = this.f13508q;
            if (i == 0) {
                return chip.performClick();
            }
            if (i == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.C;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z10 = true;
                }
                if (chip.O) {
                    chip.N.w(1, 1);
                }
            }
        }
        return z10;
    }

    @Override // b1.b
    public final void s(u0.e eVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = eVar.f12062a;
        Chip chip = this.f13508q;
        c cVar = chip.f2837z;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.f13538v0);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        eVar.i(chip.getAccessibilityClassName());
        eVar.l(chip.getText());
    }

    @Override // b1.b
    public final void t(int i, u0.e eVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = eVar.f12062a;
        if (i != 1) {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.T);
            return;
        }
        Chip chip = this.f13508q;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            accessibilityNodeInfo.setContentDescription(chip.getContext().getString(j.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        eVar.b(u0.c.f12047g);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
        eVar.i(Button.class.getName());
    }

    @Override // b1.b
    public final void u(int i, boolean z10) {
        Chip chip = this.f13508q;
        if (i == 1) {
            chip.I = z10;
        }
        c cVar = chip.f2837z;
        boolean z11 = chip.I;
        boolean zW = false;
        if (cVar.f13533q0 != null) {
            zW = cVar.W(z11 ? new int[]{R.attr.state_pressed, R.attr.state_enabled} : c.f13509k1);
        }
        if (zW) {
            chip.refreshDrawableState();
        }
    }
}
