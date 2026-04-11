package com.cncverse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StarPopupHelper.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/cncverse/StarPopupHelper;", "", "<init>", "()V", "TAG", "", "PREFS_NAME", "KEY_SHOWN_STAR_POPUP", "GITHUB_REPO_URL", "SPONSOR_URL", "showStarPopupIfNeeded", "", "context", "Landroid/content/Context;", "showStyledDialog", "activity", "Landroid/app/Activity;", "dp", "", "value", "createRoundedBackground", "Landroid/graphics/drawable/GradientDrawable;", "color", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StarPopupHelper {

    @NotNull
    private static final String GITHUB_REPO_URL = "https://github.com/NivinCNC/CNCVerse-Cloud-Stream-Extension";

    @NotNull
    public static final StarPopupHelper INSTANCE = new StarPopupHelper();

    @NotNull
    private static final String KEY_SHOWN_STAR_POPUP = "shown_star_popup_global_pay";

    @NotNull
    private static final String PREFS_NAME = "CNCVerseGlobalPrefs";

    @NotNull
    private static final String SPONSOR_URL = "https://www.paywithchai.in/nivincnc";

    @NotNull
    private static final String TAG = "StarPopupHelper";

    private StarPopupHelper() {
    }

    public final void showStarPopupIfNeeded(@NotNull final Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        if (!prefs.getBoolean(KEY_SHOWN_STAR_POPUP, false)) {
            prefs.edit().putBoolean(KEY_SHOWN_STAR_POPUP, true).apply();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.StarPopupHelper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    StarPopupHelper.showStarPopupIfNeeded$lambda$0(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showStarPopupIfNeeded$lambda$0(Context $context) {
        try {
            Activity activity = $context instanceof Activity ? (Activity) $context : null;
            if (activity == null) {
                return;
            }
            INSTANCE.showStyledDialog(activity);
        } catch (Exception e) {
            Log.e(TAG, "Error showing star popup: " + e.getMessage());
        }
    }

    private final void showStyledDialog(final Activity activity) {
        LinearLayout layout = new LinearLayout(activity);
        layout.setOrientation(1);
        layout.setPadding(INSTANCE.dp(24, activity), INSTANCE.dp(20, activity), INSTANCE.dp(24, activity), INSTANCE.dp(20, activity));
        layout.setBackgroundColor(Color.parseColor("#1a1a2e"));
        TextView $this$showStyledDialog_u24lambda_u241 = new TextView(activity);
        $this$showStyledDialog_u24lambda_u241.setText("⭐ Support CNCVerse!");
        $this$showStyledDialog_u24lambda_u241.setTextColor(-1);
        $this$showStyledDialog_u24lambda_u241.setTextSize(20.0f);
        $this$showStyledDialog_u24lambda_u241.setTypeface($this$showStyledDialog_u24lambda_u241.getTypeface(), 1);
        $this$showStyledDialog_u24lambda_u241.setGravity(17);
        $this$showStyledDialog_u24lambda_u241.setPadding(0, 0, 0, INSTANCE.dp(16, activity));
        layout.addView($this$showStyledDialog_u24lambda_u241);
        TextView $this$showStyledDialog_u24lambda_u242 = new TextView(activity);
        $this$showStyledDialog_u24lambda_u242.setText("If you enjoy this extension, please consider starring my GitHub repository.\n\nYour support helps me to continue development and keep the repo maintained! 🚀");
        $this$showStyledDialog_u24lambda_u242.setTextColor(Color.parseColor("#b0b0b0"));
        $this$showStyledDialog_u24lambda_u242.setTextSize(15.0f);
        $this$showStyledDialog_u24lambda_u242.setGravity(17);
        $this$showStyledDialog_u24lambda_u242.setPadding(0, 0, 0, INSTANCE.dp(24, activity));
        $this$showStyledDialog_u24lambda_u242.setLineSpacing(INSTANCE.dp(4, activity), 1.0f);
        layout.addView($this$showStyledDialog_u24lambda_u242);
        LinearLayout buttonContainer = new LinearLayout(activity);
        buttonContainer.setOrientation(0);
        buttonContainer.setGravity(17);
        Button starButton = new Button(activity);
        starButton.setText("⭐ Star on GitHub");
        starButton.setTextColor(-1);
        starButton.setTextSize(14.0f);
        starButton.setAllCaps(false);
        starButton.setBackground(INSTANCE.createRoundedBackground(Color.parseColor("#6c5ce7")));
        starButton.setPadding(INSTANCE.dp(20, activity), INSTANCE.dp(12, activity), INSTANCE.dp(20, activity), INSTANCE.dp(12, activity));
        LinearLayout.LayoutParams $this$showStyledDialog_u24lambda_u244_u240 = new LinearLayout.LayoutParams(-2, -2);
        $this$showStyledDialog_u24lambda_u244_u240.setMarginEnd(INSTANCE.dp(12, activity));
        starButton.setLayoutParams($this$showStyledDialog_u24lambda_u244_u240);
        buttonContainer.addView(starButton);
        Button sponsorButton = new Button(activity);
        sponsorButton.setText("❤️ Sponsor (UPI)");
        sponsorButton.setTextColor(-1);
        sponsorButton.setTextSize(14.0f);
        sponsorButton.setAllCaps(false);
        sponsorButton.setBackground(INSTANCE.createRoundedBackground(Color.parseColor("#6c5ce7")));
        sponsorButton.setPadding(INSTANCE.dp(20, activity), INSTANCE.dp(12, activity), INSTANCE.dp(20, activity), INSTANCE.dp(12, activity));
        buttonContainer.addView(sponsorButton);
        layout.addView(buttonContainer);
        final AlertDialog dialog = new AlertDialog.Builder(activity).setView(layout).setCancelable(true).create();
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        starButton.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.StarPopupHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StarPopupHelper.showStyledDialog$lambda$6(activity, dialog, view);
            }
        });
        sponsorButton.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.StarPopupHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StarPopupHelper.showStyledDialog$lambda$7(activity, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showStyledDialog$lambda$6(Activity $activity, AlertDialog $dialog, View it) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(GITHUB_REPO_URL));
            $activity.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "Error opening GitHub: " + e.getMessage());
        }
        $dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showStyledDialog$lambda$7(Activity $activity, AlertDialog $dialog, View it) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(SPONSOR_URL));
            $activity.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "Error opening Sponsor: " + e.getMessage());
        }
        $dialog.dismiss();
    }

    private final int dp(int value, Context context) {
        return (int) TypedValue.applyDimension(1, value, context.getResources().getDisplayMetrics());
    }

    private final GradientDrawable createRoundedBackground(int color) {
        GradientDrawable $this$createRoundedBackground_u24lambda_u240 = new GradientDrawable();
        $this$createRoundedBackground_u24lambda_u240.setColor(color);
        $this$createRoundedBackground_u24lambda_u240.setCornerRadius(24.0f);
        return $this$createRoundedBackground_u24lambda_u240;
    }
}
