package b9;

import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import p8.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends y0.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Chip f1947q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Chip chip, Chip chip2) {
        super(chip2);
        this.f1947q = chip;
    }

    @Override // y0.b
    public final void l(ArrayList arrayList) {
        e eVar;
        arrayList.add(0);
        int i = Chip.R;
        Chip chip = this.f1947q;
        if (!chip.c() || (eVar = chip.f3378y) == null || !eVar.f1954f0 || chip.B == null) {
            return;
        }
        arrayList.add(1);
    }

    @Override // y0.b
    public final void o(int i, r0.e eVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = eVar.f11226a;
        if (i != 1) {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.S);
            return;
        }
        Chip chip = this.f1947q;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            accessibilityNodeInfo.setContentDescription(chip.getContext().getString(j.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        eVar.b(r0.d.f11212g);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
    }
}
