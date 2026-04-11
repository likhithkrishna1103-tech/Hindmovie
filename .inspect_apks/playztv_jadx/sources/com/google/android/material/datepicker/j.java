package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends q0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3404e;

    public /* synthetic */ j(int i, Object obj) {
        this.f3403d = i;
        this.f3404e = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // q0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
        /*
            r2 = this;
            int r0 = r2.f3403d
            switch(r0) {
                case 1: goto L47;
                case 2: goto L5;
                case 3: goto L9;
                default: goto L5;
            }
        L5:
            super.c(r3, r4)
            return
        L9:
            java.lang.Object r0 = r2.f3404e
            k5.i r0 = (k5.i) r0
            super.c(r3, r4)
            java.lang.Class<k5.i> r3 = k5.i.class
            java.lang.String r3 = r3.getName()
            r4.setClassName(r3)
            k5.a r3 = r0.f7056y
            if (r3 == 0) goto L25
            int r3 = r3.c()
            r1 = 1
            if (r3 <= r1) goto L25
            goto L26
        L25:
            r1 = 0
        L26:
            r4.setScrollable(r1)
            int r3 = r4.getEventType()
            r1 = 4096(0x1000, float:5.74E-42)
            if (r3 != r1) goto L46
            k5.a r3 = r0.f7056y
            if (r3 == 0) goto L46
            int r3 = r3.c()
            r4.setItemCount(r3)
            int r3 = r0.f7057z
            r4.setFromIndex(r3)
            int r3 = r0.f7057z
            r4.setToIndex(r3)
        L46:
            return
        L47:
            super.c(r3, r4)
            java.lang.Object r3 = r2.f3404e
            com.google.android.material.internal.CheckableImageButton r3 = (com.google.android.material.internal.CheckableImageButton) r3
            boolean r3 = r3.f3458x
            r4.setChecked(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.j.c(android.view.View, android.view.accessibility.AccessibilityEvent):void");
    }

    @Override // q0.b
    public final void d(View view, r0.e eVar) {
        int i;
        int i10 = this.f3403d;
        boolean z2 = false;
        z2 = false;
        Object obj = this.f3404e;
        View.AccessibilityDelegate accessibilityDelegate = this.f10418a;
        switch (i10) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, eVar.f11226a);
                m mVar = (m) obj;
                eVar.k(mVar.C0.getVisibility() == 0 ? mVar.m().getString(p8.j.mtrl_picker_toggle_to_year_selection) : mVar.m().getString(p8.j.mtrl_picker_toggle_to_day_selection));
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo = eVar.f11226a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f3459y);
                accessibilityNodeInfo.setChecked(checkableImageButton.f3458x);
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo2 = eVar.f11226a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) obj).R);
                break;
            case 3:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, eVar.f11226a);
                eVar.i(k5.i.class.getName());
                k5.i iVar = (k5.i) obj;
                k5.a aVar = iVar.f7056y;
                if (aVar != null && aVar.c() > 1) {
                    z2 = true;
                }
                eVar.l(z2);
                if (iVar.canScrollHorizontally(1)) {
                    eVar.a(4096);
                }
                if (iVar.canScrollHorizontally(-1)) {
                    eVar.a(8192);
                }
                break;
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, eVar.f11226a);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                int i11 = MaterialButtonToggleGroup.E;
                if (view instanceof MaterialButton) {
                    int i12 = 0;
                    for (int i13 = 0; i13 < materialButtonToggleGroup.getChildCount(); i13++) {
                        if (materialButtonToggleGroup.getChildAt(i13) == view) {
                            i = i12;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i13) instanceof MaterialButton) && materialButtonToggleGroup.c(i13)) {
                                i12++;
                            }
                        }
                    }
                    i = -1;
                } else {
                    i = -1;
                }
                eVar.j(e7.c.a(0, 1, i, 1, false, ((MaterialButton) view).I));
                break;
        }
    }

    @Override // q0.b
    public boolean g(View view, int i, Bundle bundle) {
        switch (this.f3403d) {
            case 3:
                k5.i iVar = (k5.i) this.f3404e;
                if (super.g(view, i, bundle)) {
                    return true;
                }
                if (i != 4096) {
                    if (i == 8192 && iVar.canScrollHorizontally(-1)) {
                        iVar.setCurrentItem(iVar.f7057z - 1);
                        return true;
                    }
                } else if (iVar.canScrollHorizontally(1)) {
                    iVar.setCurrentItem(iVar.f7057z + 1);
                    return true;
                }
                return false;
            default:
                return super.g(view, i, bundle);
        }
    }
}
