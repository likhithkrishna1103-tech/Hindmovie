package o;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a2 {
    public static int a(PopupWindow popupWindow, View view, int i, boolean z10) {
        return popupWindow.getMaxAvailableHeight(view, i, z10);
    }
}
