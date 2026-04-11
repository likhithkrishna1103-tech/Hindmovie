package e1;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        DrawerLayout drawerLayout = (DrawerLayout) view;
        boolean z2 = false;
        boolean z10 = windowInsets.getSystemWindowInsetTop() > 0;
        drawerLayout.R = windowInsets;
        drawerLayout.S = z10;
        if (!z10 && drawerLayout.getBackground() == null) {
            z2 = true;
        }
        drawerLayout.setWillNotDraw(z2);
        drawerLayout.requestLayout();
        return windowInsets.consumeSystemWindowInsets();
    }
}
