package n;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a2 {
    public static int a(PopupWindow popupWindow, View view, int i, boolean z2) {
        return popupWindow.getMaxAvailableHeight(view, i, z2);
    }
}
