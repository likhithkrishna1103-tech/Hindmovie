package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends t0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2861e;

    public /* synthetic */ j(int i, Object obj) {
        this.f2860d = i;
        this.f2861e = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // t0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
        /*
            r2 = this;
            int r0 = r2.f2860d
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
            java.lang.Object r0 = r2.f2861e
            p5.g r0 = (p5.g) r0
            super.c(r3, r4)
            java.lang.Class<p5.g> r3 = p5.g.class
            java.lang.String r3 = r3.getName()
            r4.setClassName(r3)
            p5.a r3 = r0.f10027z
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
            p5.a r3 = r0.f10027z
            if (r3 == 0) goto L46
            int r3 = r3.c()
            r4.setItemCount(r3)
            int r3 = r0.A
            r4.setFromIndex(r3)
            int r3 = r0.A
            r4.setToIndex(r3)
        L46:
            return
        L47:
            super.c(r3, r4)
            java.lang.Object r3 = r2.f2861e
            com.google.android.material.internal.CheckableImageButton r3 = (com.google.android.material.internal.CheckableImageButton) r3
            boolean r3 = r3.f2921y
            r4.setChecked(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.j.c(android.view.View, android.view.accessibility.AccessibilityEvent):void");
    }

    @Override // t0.b
    public final void d(View view, u0.e eVar) {
        int i;
        int i10 = this.f2860d;
        boolean z10 = false;
        z10 = false;
        Object obj = this.f2861e;
        View.AccessibilityDelegate accessibilityDelegate = this.f11731a;
        switch (i10) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, eVar.f12062a);
                m mVar = (m) obj;
                eVar.b(new u0.c(16, mVar.D0.getVisibility() == 0 ? mVar.m().getString(k9.j.mtrl_picker_toggle_to_year_selection) : mVar.m().getString(k9.j.mtrl_picker_toggle_to_day_selection)));
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo = eVar.f12062a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f2922z);
                accessibilityNodeInfo.setChecked(checkableImageButton.f2921y);
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo2 = eVar.f12062a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) obj).S);
                break;
            case 3:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, eVar.f12062a);
                eVar.i(p5.g.class.getName());
                p5.g gVar = (p5.g) obj;
                p5.a aVar = gVar.f10027z;
                if (aVar != null && aVar.c() > 1) {
                    z10 = true;
                }
                eVar.k(z10);
                if (gVar.canScrollHorizontally(1)) {
                    eVar.a(4096);
                }
                if (gVar.canScrollHorizontally(-1)) {
                    eVar.a(8192);
                }
                break;
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, eVar.f12062a);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                int i11 = MaterialButtonToggleGroup.M;
                if (view instanceof MaterialButton) {
                    int i12 = 0;
                    for (int i13 = 0; i13 < materialButtonToggleGroup.getChildCount(); i13++) {
                        if (materialButtonToggleGroup.getChildAt(i13) == view) {
                            i = i12;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i13) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i13).getVisibility() != 8) {
                                i12++;
                            }
                        }
                    }
                    i = -1;
                } else {
                    i = -1;
                }
                eVar.j(u0.d.a(0, 1, i, 1, false, ((MaterialButton) view).J));
                break;
        }
    }

    @Override // t0.b
    public boolean g(View view, int i, Bundle bundle) {
        switch (this.f2860d) {
            case 3:
                p5.g gVar = (p5.g) this.f2861e;
                if (super.g(view, i, bundle)) {
                    return true;
                }
                if (i != 4096) {
                    if (i == 8192 && gVar.canScrollHorizontally(-1)) {
                        gVar.setCurrentItem(gVar.A - 1);
                        return true;
                    }
                } else if (gVar.canScrollHorizontally(1)) {
                    gVar.setCurrentItem(gVar.A + 1);
                    return true;
                }
                return false;
            default:
                return super.g(view, i, bundle);
        }
    }
}
