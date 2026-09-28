package com.phisher98.donation;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonationDialogFragment.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017b\u0010\b\u0014\u0012\f\b\u0015\u0012\b\b\fJ\u0004\b\b(\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/phisher98/donation/DonationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "config", "Lcom/phisher98/donation/DonationConfig;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/donation/DonationConfig;Lkotlin/jvm/functions/Function0;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Landroid/annotation/SuppressLint;", "value", "SetTextI18n", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroy", "openUrl", "context", "Landroid/content/Context;", "url", "", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDonationDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationDialogFragment.kt\ncom/phisher98/donation/DonationDialogFragment\n+ 2 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,580:1\n27#2:581\n432#3:582\n432#3:583\n432#3:584\n432#3:585\n432#3:587\n432#3:588\n432#3:589\n432#3:590\n432#3:591\n432#3:592\n432#3:593\n432#3:594\n432#3:595\n432#3:596\n432#3:597\n432#3:598\n432#3:599\n432#3:600\n432#3:601\n432#3:602\n432#3:603\n432#3:604\n432#3:605\n432#3:606\n432#3:607\n432#3:608\n432#3:609\n432#3:610\n432#3:612\n432#3:613\n432#3:614\n432#3:615\n432#3:616\n432#3:617\n432#3:618\n1#4:586\n29#5:611\n*S KotlinDebug\n*F\n+ 1 DonationDialogFragment.kt\ncom/phisher98/donation/DonationDialogFragment\n*L\n37#1:581\n71#1:582\n73#1:583\n87#1:584\n88#1:585\n110#1:587\n113#1:588\n115#1:589\n131#1:590\n134#1:591\n161#1:592\n257#1:593\n260#1:594\n278#1:595\n320#1:596\n325#1:597\n339#1:598\n351#1:599\n352#1:600\n377#1:601\n408#1:602\n410#1:603\n442#1:604\n447#1:605\n469#1:606\n471#1:607\n476#1:608\n498#1:609\n523#1:610\n186#1:612\n188#1:613\n207#1:614\n452#1:615\n453#1:616\n481#1:617\n509#1:618\n573#1:611\n*E\n"})
public final class DonationDialogFragment extends DialogFragment {

    @NotNull
    private final DonationConfig config;

    @Nullable
    private final Function0<Unit> onDismissCallback;

    public DonationDialogFragment(@NotNull DonationConfig config, @Nullable Function0<Unit> function0) {
        this.config = config;
        this.onDismissCallback = function0;
    }

    public /* synthetic */ DonationDialogFragment(DonationConfig donationConfig, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(donationConfig, (i & 2) != 0 ? null : function0);
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(1);
        Window $this$onCreateDialog_u24lambda_u240 = dialog.getWindow();
        if ($this$onCreateDialog_u24lambda_u240 != null) {
            $this$onCreateDialog_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
            $this$onCreateDialog_u24lambda_u240.setDimAmount(0.7f);
        }
        return dialog;
    }

    public void onStart() {
        Window $this$onStart_u24lambda_u240;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && ($this$onStart_u24lambda_u240 = dialog.getWindow()) != null) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int maxAllowedWidth = (int) (440.0f * metrics.density);
            int screenWidth = (int) (((double) metrics.widthPixels) * 0.92d);
            $this$onStart_u24lambda_u240.setLayout(Math.min(screenWidth, maxAllowedWidth), -2);
            $this$onStart_u24lambda_u240.setGravity(17);
        }
    }

    /* JADX WARN: Type inference failed for: r12v79, types: [com.phisher98.donation.DonationDialogFragment$onCreateView$ticker$1] */
    @SuppressLint({"SetTextI18n"})
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String cur;
        String str;
        final Context ctx = requireContext();
        final float density = ctx.getResources().getDisplayMetrics().density;
        boolean achieved = this.config.isGoalAchieved();
        LinearLayout root = new LinearLayout(ctx);
        root.setOrientation(1);
        GradientDrawable $this$onCreateView_u24lambda_u241_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u241_u240.setColor(Color.parseColor("#13161F"));
        $this$onCreateView_u24lambda_u241_u240.setCornerRadius(onCreateView$dp(density, 22));
        $this$onCreateView_u24lambda_u241_u240.setStroke(onCreateView$dp(density, 1), Color.parseColor("#252B3B"));
        root.setBackground($this$onCreateView_u24lambda_u241_u240);
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout heroSection = new LinearLayout(ctx);
        heroSection.setOrientation(1);
        heroSection.setPadding(onCreateView$dp(density, 20), onCreateView$dp(density, 20), onCreateView$dp(density, 20), onCreateView$dp(density, 18));
        GradientDrawable $this$onCreateView_u24lambda_u242_u240 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, achieved ? new int[]{Color.parseColor("#1A2E1A"), Color.parseColor("#13161F")} : new int[]{Color.parseColor("#131826"), Color.parseColor("#13161F")});
        $this$onCreateView_u24lambda_u242_u240.setCornerRadii(new float[]{onCreateView$dp$0(density, 22.0f), onCreateView$dp$0(density, 22.0f), onCreateView$dp$0(density, 22.0f), onCreateView$dp$0(density, 22.0f), 0.0f, 0.0f, 0.0f, 0.0f});
        heroSection.setBackground($this$onCreateView_u24lambda_u242_u240);
        heroSection.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout badgeRow = new LinearLayout(ctx);
        badgeRow.setOrientation(0);
        badgeRow.setGravity(16);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u243_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u243_u240.bottomMargin = onCreateView$dp(density, 14);
        badgeRow.setLayoutParams($this$onCreateView_u24lambda_u243_u240);
        TextView badgeChip = new TextView(ctx);
        badgeChip.setText("⚡ Phisher Repo  •  phisher98 ↗");
        badgeChip.setTextSize(11.0f);
        badgeChip.setTypeface(Typeface.DEFAULT_BOLD);
        badgeChip.setTextColor(Color.parseColor("#93C5FD"));
        badgeChip.setPadding(onCreateView$dp(density, 10), onCreateView$dp(density, 4), onCreateView$dp(density, 10), onCreateView$dp(density, 4));
        GradientDrawable $this$onCreateView_u24lambda_u244_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u244_u240.setColor(Color.parseColor("#1E293B"));
        $this$onCreateView_u24lambda_u244_u240.setCornerRadius(onCreateView$dp(density, 6));
        $this$onCreateView_u24lambda_u244_u240.setStroke(onCreateView$dp(density, 1), Color.parseColor("#334155"));
        badgeChip.setBackground($this$onCreateView_u24lambda_u244_u240);
        badgeChip.setClickable(true);
        badgeChip.setFocusable(true);
        badgeChip.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.openUrl(ctx, "https://github.com/phisher98");
            }
        });
        badgeChip.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        badgeRow.addView(badgeChip);
        View $this$onCreateView_u24lambda_u245 = new View(ctx);
        $this$onCreateView_u24lambda_u245.setLayoutParams(new LinearLayout.LayoutParams(0, 1, 1.0f));
        Unit unit = Unit.INSTANCE;
        badgeRow.addView($this$onCreateView_u24lambda_u245);
        TextView monthChip = new TextView(ctx);
        monthChip.setText(this.config.getMonth());
        monthChip.setTextSize(10.5f);
        monthChip.setTextColor(Color.parseColor("#CBD5E1"));
        monthChip.setPadding(onCreateView$dp(density, 8), onCreateView$dp(density, 3), onCreateView$dp(density, 8), onCreateView$dp(density, 3));
        GradientDrawable $this$onCreateView_u24lambda_u246_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u246_u240.setColor(Color.parseColor("#1A1F2E"));
        $this$onCreateView_u24lambda_u246_u240.setCornerRadius(onCreateView$dp(density, 5));
        monthChip.setBackground($this$onCreateView_u24lambda_u246_u240);
        badgeRow.addView(monthChip);
        heroSection.addView(badgeRow);
        TextView titleView = new TextView(ctx);
        titleView.setText(achieved ? "🎉 Goal Achieved!" : "⚡ Support Phisher Repo");
        titleView.setTextSize(22.0f);
        titleView.setTextColor(-1);
        titleView.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u247_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u247_u240.bottomMargin = onCreateView$dp(density, 6);
        titleView.setLayoutParams($this$onCreateView_u24lambda_u247_u240);
        heroSection.addView(titleView);
        TextView $this$onCreateView_u24lambda_u248 = new TextView(ctx);
        $this$onCreateView_u24lambda_u248.setText(achieved ? "The monthly maintenance goal is fully funded — thank you! 🙌" : "Keep 80+ free extensions alive. No ads, no paywalls — just community support.");
        $this$onCreateView_u24lambda_u248.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u248.setTextColor(Color.parseColor("#94A3B8"));
        $this$onCreateView_u24lambda_u248.setLineSpacing(0.0f, 1.35f);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u248_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u248_u240.bottomMargin = onCreateView$dp(density, 16);
        $this$onCreateView_u24lambda_u248.setLayoutParams($this$onCreateView_u24lambda_u248_u240);
        heroSection.addView($this$onCreateView_u24lambda_u248);
        LinearLayout statsRow = new LinearLayout(ctx);
        statsRow.setOrientation(0);
        statsRow.setGravity(16);
        statsRow.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (achieved) {
            statsRow.addView(onCreateView$statChip(ctx, density, "🏆", "Goal Reached", "#4ADE80"));
            statsRow.addView(onCreateView$statChip(ctx, density, "👥", this.config.getSupportersCount() + " Supporters", "#93C5FD"));
        } else {
            statsRow.addView(onCreateView$statChip(ctx, density, "🔓", "100% Free", "#4ADE80"));
            statsRow.addView(onCreateView$statChip(ctx, density, "🔧", "80+ Extensions", "#93C5FD"));
        }
        heroSection.addView(statsRow);
        if (!achieved) {
            List warnings = CollectionsKt.listOf(new Triple[]{new Triple("⌛", "Goal Missed = Slower Updates:", "If target isn't met, fixes & updates will slow down."), new Triple("💀", "No Support = Extensions Die:", "Scrapers break and links die without ongoing maintenance.")});
            LinearLayout warningsContainer = new LinearLayout(ctx);
            warningsContainer.setOrientation(1);
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2413_u240 = new LinearLayout.LayoutParams(-1, -2);
            $this$onCreateView_u24lambda_u2413_u240.topMargin = onCreateView$dp(density, 12);
            warningsContainer.setLayoutParams($this$onCreateView_u24lambda_u2413_u240);
            Iterator it = warnings.iterator();
            while (it.hasNext()) {
                Triple triple = (Triple) it.next();
                String icon = (String) triple.component1();
                String head = (String) triple.component2();
                String body = (String) triple.component3();
                LinearLayout row = new LinearLayout(ctx);
                Iterator it2 = it;
                row.setOrientation(0);
                row.setGravity(48);
                TextView badgeChip2 = badgeChip;
                LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2414_u240 = new LinearLayout.LayoutParams(-1, -2);
                $this$onCreateView_u24lambda_u2414_u240.bottomMargin = onCreateView$dp(density, 5);
                row.setLayoutParams($this$onCreateView_u24lambda_u2414_u240);
                TextView $this$onCreateView_u24lambda_u2415 = new TextView(ctx);
                $this$onCreateView_u24lambda_u2415.setText(icon);
                $this$onCreateView_u24lambda_u2415.setTextSize(12.0f);
                LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2415_u240 = new LinearLayout.LayoutParams(-2, -2);
                $this$onCreateView_u24lambda_u2415_u240.rightMargin = onCreateView$dp(density, 7);
                TextView monthChip2 = monthChip;
                $this$onCreateView_u24lambda_u2415_u240.topMargin = onCreateView$dp(density, 1);
                $this$onCreateView_u24lambda_u2415.setLayoutParams($this$onCreateView_u24lambda_u2415_u240);
                TextView $this$onCreateView_u24lambda_u2416 = new TextView(ctx);
                SpannableStringBuilder $this$onCreateView_u24lambda_u2416_u240 = new SpannableStringBuilder();
                int s = $this$onCreateView_u24lambda_u2416_u240.length();
                $this$onCreateView_u24lambda_u2416_u240.append((CharSequence) head);
                $this$onCreateView_u24lambda_u2416_u240.setSpan(new StyleSpan(1), s, $this$onCreateView_u24lambda_u2416_u240.length(), 33);
                $this$onCreateView_u24lambda_u2416_u240.setSpan(new ForegroundColorSpan(Color.parseColor("#E2E8F0")), s, $this$onCreateView_u24lambda_u2416_u240.length(), 33);
                $this$onCreateView_u24lambda_u2416_u240.append((CharSequence) " ");
                int s2 = $this$onCreateView_u24lambda_u2416_u240.length();
                $this$onCreateView_u24lambda_u2416_u240.append((CharSequence) body);
                $this$onCreateView_u24lambda_u2416_u240.setSpan(new ForegroundColorSpan(Color.parseColor("#94A3B8")), s2, $this$onCreateView_u24lambda_u2416_u240.length(), 33);
                $this$onCreateView_u24lambda_u2416.setText($this$onCreateView_u24lambda_u2416_u240);
                $this$onCreateView_u24lambda_u2416.setTextSize(12.0f);
                $this$onCreateView_u24lambda_u2416.setLineSpacing(0.0f, 1.25f);
                $this$onCreateView_u24lambda_u2416.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
                row.addView($this$onCreateView_u24lambda_u2415);
                row.addView($this$onCreateView_u24lambda_u2416);
                warningsContainer.addView(row);
                it = it2;
                badgeChip = badgeChip2;
                monthChip = monthChip2;
                titleView = titleView;
            }
            heroSection.addView(warningsContainer);
        }
        root.addView(heroSection);
        View $this$onCreateView_u24lambda_u2417 = new View(ctx);
        $this$onCreateView_u24lambda_u2417.setBackgroundColor(Color.parseColor("#1E2433"));
        $this$onCreateView_u24lambda_u2417.setLayoutParams(new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 1)));
        Unit unit2 = Unit.INSTANCE;
        root.addView($this$onCreateView_u24lambda_u2417);
        LinearLayout progressSection = new LinearLayout(ctx);
        progressSection.setOrientation(1);
        progressSection.setPadding(onCreateView$dp(density, 20), onCreateView$dp(density, 16), onCreateView$dp(density, 20), onCreateView$dp(density, 4));
        progressSection.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout amountRow = new LinearLayout(ctx);
        amountRow.setOrientation(0);
        amountRow.setGravity(16);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2419_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u2419_u240.bottomMargin = onCreateView$dp(density, 10);
        amountRow.setLayoutParams($this$onCreateView_u24lambda_u2419_u240);
        TextView $this$onCreateView_u24lambda_u2420 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2420.setText(achieved ? "Monthly Goal" : "Progress this month");
        $this$onCreateView_u24lambda_u2420.setTextSize(12.0f);
        $this$onCreateView_u24lambda_u2420.setTextColor(-1);
        $this$onCreateView_u24lambda_u2420.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        amountRow.addView($this$onCreateView_u24lambda_u2420);
        boolean z = this.config.getCurrentAmount() % 1.0d == 0.0d;
        DonationConfig donationConfig = this.config;
        if (z) {
            cur = String.valueOf((int) donationConfig.getCurrentAmount());
        } else {
            cur = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(donationConfig.getCurrentAmount())}, 1));
            Intrinsics.checkNotNullExpressionValue(cur, "format(...)");
        }
        String tgt = String.valueOf((int) this.config.getTargetAmount());
        TextView $this$onCreateView_u24lambda_u2421 = new TextView(ctx);
        SpannableStringBuilder $this$onCreateView_u24lambda_u2421_u240 = new SpannableStringBuilder();
        int s1 = $this$onCreateView_u24lambda_u2421_u240.length();
        $this$onCreateView_u24lambda_u2421_u240.append((CharSequence) (this.config.getCurrency() + cur));
        $this$onCreateView_u24lambda_u2421_u240.setSpan(new StyleSpan(1), s1, $this$onCreateView_u24lambda_u2421_u240.length(), 33);
        $this$onCreateView_u24lambda_u2421_u240.setSpan(new ForegroundColorSpan(achieved ? Color.parseColor("#4ADE80") : Color.parseColor("#22C55E")), s1, $this$onCreateView_u24lambda_u2421_u240.length(), 33);
        int s3 = $this$onCreateView_u24lambda_u2421_u240.length();
        $this$onCreateView_u24lambda_u2421_u240.append((CharSequence) ("  /  " + this.config.getCurrency() + tgt));
        $this$onCreateView_u24lambda_u2421_u240.setSpan(new ForegroundColorSpan(Color.parseColor("#CBD5E1")), s3, $this$onCreateView_u24lambda_u2421_u240.length(), 33);
        $this$onCreateView_u24lambda_u2421.setText($this$onCreateView_u24lambda_u2421_u240);
        $this$onCreateView_u24lambda_u2421.setTextSize(14.0f);
        amountRow.addView($this$onCreateView_u24lambda_u2421);
        progressSection.addView(amountRow);
        int pct = RangesKt.coerceIn(this.config.getProgressPercentage(), 0, 100);
        LinearLayout progressTrack = new LinearLayout(ctx);
        progressTrack.setOrientation(0);
        progressTrack.setWeightSum(100.0f);
        GradientDrawable $this$onCreateView_u24lambda_u2422_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u2422_u240.setColor(Color.parseColor("#1E2330"));
        $this$onCreateView_u24lambda_u2422_u240.setCornerRadius(onCreateView$dp(density, 6));
        progressTrack.setBackground($this$onCreateView_u24lambda_u2422_u240);
        progressTrack.setClipToOutline(true);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2422_u241 = new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 12));
        $this$onCreateView_u24lambda_u2422_u241.bottomMargin = onCreateView$dp(density, 8);
        progressTrack.setLayoutParams($this$onCreateView_u24lambda_u2422_u241);
        if (pct > 0) {
            View $this$onCreateView_u24lambda_u2423 = new View(ctx);
            GradientDrawable $this$onCreateView_u24lambda_u2423_u240 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, achieved ? new int[]{Color.parseColor("#22C55E"), Color.parseColor("#4ADE80")} : new int[]{Color.parseColor("#16A34A"), Color.parseColor("#22C55E")});
            $this$onCreateView_u24lambda_u2423_u240.setCornerRadius(onCreateView$dp(density, 6));
            $this$onCreateView_u24lambda_u2423.setBackground($this$onCreateView_u24lambda_u2423_u240);
            $this$onCreateView_u24lambda_u2423.setLayoutParams(new LinearLayout.LayoutParams(0, -1, pct));
            Unit unit3 = Unit.INSTANCE;
            progressTrack.addView($this$onCreateView_u24lambda_u2423);
        }
        if (pct < 100) {
            View $this$onCreateView_u24lambda_u2424 = new View(ctx);
            $this$onCreateView_u24lambda_u2424.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 100 - pct));
            Unit unit4 = Unit.INSTANCE;
            progressTrack.addView($this$onCreateView_u24lambda_u2424);
        }
        progressSection.addView(progressTrack);
        LinearLayout progressMetaRow = new LinearLayout(ctx);
        progressMetaRow.setOrientation(0);
        progressMetaRow.setGravity(16);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2425_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u2425_u240.bottomMargin = onCreateView$dp(density, 16);
        progressMetaRow.setLayoutParams($this$onCreateView_u24lambda_u2425_u240);
        TextView $this$onCreateView_u24lambda_u2426 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2426.setText(this.config.getProgressPercentage() + "% funded");
        $this$onCreateView_u24lambda_u2426.setTextSize(11.0f);
        $this$onCreateView_u24lambda_u2426.setTypeface(Typeface.DEFAULT_BOLD);
        $this$onCreateView_u24lambda_u2426.setTextColor(achieved ? Color.parseColor("#4ADE80") : Color.parseColor("#22C55E"));
        $this$onCreateView_u24lambda_u2426.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        progressMetaRow.addView($this$onCreateView_u24lambda_u2426);
        TextView $this$onCreateView_u24lambda_u2427 = new TextView(ctx);
        DonationConfig donationConfig2 = this.config;
        if (achieved) {
            str = "🙌 " + donationConfig2.getSupportersCount() + " supporters";
        } else if (donationConfig2.getSupportersCount() > 0) {
            str = "🙌 " + this.config.getSupportersCount() + " supporter" + (this.config.getSupportersCount() == 1 ? "" : "s") + " so far";
        }
        $this$onCreateView_u24lambda_u2427.setText(str);
        $this$onCreateView_u24lambda_u2427.setTextSize(11.0f);
        $this$onCreateView_u24lambda_u2427.setTextColor(-1);
        progressMetaRow.addView($this$onCreateView_u24lambda_u2427);
        progressSection.addView(progressMetaRow);
        root.addView(progressSection);
        LinearLayout btnSection = new LinearLayout(ctx);
        btnSection.setOrientation(1);
        btnSection.setPadding(onCreateView$dp(density, 16), onCreateView$dp(density, 0), onCreateView$dp(density, 16), onCreateView$dp(density, 16));
        btnSection.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (!StringsKt.isBlank(this.config.getPrimaryDonateUrl())) {
            final GradientDrawable $this$onCreateView_u24lambda_u2429 = new GradientDrawable();
            $this$onCreateView_u24lambda_u2429.setColors(achieved ? new int[]{Color.parseColor("#16A34A"), Color.parseColor("#15803D")} : new int[]{Color.parseColor("#4F46E5"), Color.parseColor("#5865F2")});
            $this$onCreateView_u24lambda_u2429.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            $this$onCreateView_u24lambda_u2429.setCornerRadius(onCreateView$dp(density, 14));
            Button $this$onCreateView_u24lambda_u2430 = new Button(ctx);
            $this$onCreateView_u24lambda_u2430.setText(this.config.getPrimaryButtonText());
            $this$onCreateView_u24lambda_u2430.setTextSize(15.0f);
            $this$onCreateView_u24lambda_u2430.setTextColor(-1);
            $this$onCreateView_u24lambda_u2430.setAllCaps(false);
            $this$onCreateView_u24lambda_u2430.setTypeface(Typeface.DEFAULT_BOLD);
            $this$onCreateView_u24lambda_u2430.setFocusable(true);
            $this$onCreateView_u24lambda_u2430.setBackground($this$onCreateView_u24lambda_u2429);
            $this$onCreateView_u24lambda_u2430.setPadding(onCreateView$dp(density, 20), onCreateView$dp(density, 0), onCreateView$dp(density, 20), onCreateView$dp(density, 0));
            $this$onCreateView_u24lambda_u2430.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    DonationDialogFragment.onCreateView$lambda$30$0($this$onCreateView_u24lambda_u2429, view, z2);
                }
            });
            $this$onCreateView_u24lambda_u2430.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonationDialogFragment.onCreateView$lambda$30$1(this.f$0, ctx, view);
                }
            });
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2430_u242 = new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 50));
            $this$onCreateView_u24lambda_u2430_u242.bottomMargin = onCreateView$dp(density, 10);
            $this$onCreateView_u24lambda_u2430.setLayoutParams($this$onCreateView_u24lambda_u2430_u242);
            btnSection.addView($this$onCreateView_u24lambda_u2430);
        }
        if (!StringsKt.isBlank(this.config.getAdSupportUrl())) {
            final GradientDrawable $this$onCreateView_u24lambda_u2431 = new GradientDrawable();
            $this$onCreateView_u24lambda_u2431.setColor(0);
            $this$onCreateView_u24lambda_u2431.setCornerRadius(onCreateView$dp(density, 14));
            $this$onCreateView_u24lambda_u2431.setStroke(onCreateView$dp(density, 1), Color.parseColor("#2D3748"));
            final Button $this$onCreateView_u24lambda_u2432 = new Button(ctx);
            $this$onCreateView_u24lambda_u2432.setText(this.config.getAdSupportButtonText());
            $this$onCreateView_u24lambda_u2432.setTextSize(13.0f);
            $this$onCreateView_u24lambda_u2432.setTextColor(Color.parseColor("#93C5FD"));
            $this$onCreateView_u24lambda_u2432.setAllCaps(false);
            $this$onCreateView_u24lambda_u2432.setFocusable(true);
            $this$onCreateView_u24lambda_u2432.setBackground($this$onCreateView_u24lambda_u2431);
            $this$onCreateView_u24lambda_u2432.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    DonationDialogFragment.onCreateView$lambda$32$0($this$onCreateView_u24lambda_u2431, $this$onCreateView_u24lambda_u2432, density, view, z2);
                }
            });
            $this$onCreateView_u24lambda_u2432.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonationDialogFragment.onCreateView$lambda$32$1(this.f$0, ctx, view);
                }
            });
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2432_u242 = new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 46));
            $this$onCreateView_u24lambda_u2432_u242.bottomMargin = onCreateView$dp(density, 10);
            $this$onCreateView_u24lambda_u2432.setLayoutParams($this$onCreateView_u24lambda_u2432_u242);
            btnSection.addView($this$onCreateView_u24lambda_u2432);
        }
        if (!StringsKt.isBlank(this.config.getSecondaryDonateUrl())) {
            final GradientDrawable $this$onCreateView_u24lambda_u2433 = new GradientDrawable();
            $this$onCreateView_u24lambda_u2433.setColor(Color.parseColor("#1A1F2E"));
            $this$onCreateView_u24lambda_u2433.setCornerRadius(onCreateView$dp(density, 14));
            $this$onCreateView_u24lambda_u2433.setStroke(onCreateView$dp(density, 1), Color.parseColor("#2D3748"));
            Button $this$onCreateView_u24lambda_u2434 = new Button(ctx);
            $this$onCreateView_u24lambda_u2434.setText(this.config.getSecondaryButtonText());
            $this$onCreateView_u24lambda_u2434.setTextSize(13.0f);
            $this$onCreateView_u24lambda_u2434.setTextColor(Color.parseColor("#CBD5E1"));
            $this$onCreateView_u24lambda_u2434.setAllCaps(false);
            $this$onCreateView_u24lambda_u2434.setFocusable(true);
            $this$onCreateView_u24lambda_u2434.setBackground($this$onCreateView_u24lambda_u2433);
            $this$onCreateView_u24lambda_u2434.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z2) {
                    DonationDialogFragment.onCreateView$lambda$34$0($this$onCreateView_u24lambda_u2433, view, z2);
                }
            });
            $this$onCreateView_u24lambda_u2434.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonationDialogFragment.onCreateView$lambda$34$1(this.f$0, ctx, view);
                }
            });
            LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2434_u242 = new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 46));
            $this$onCreateView_u24lambda_u2434_u242.bottomMargin = onCreateView$dp(density, 10);
            $this$onCreateView_u24lambda_u2434.setLayoutParams($this$onCreateView_u24lambda_u2434_u242);
            btnSection.addView($this$onCreateView_u24lambda_u2434);
        }
        final GradientDrawable $this$onCreateView_u24lambda_u2435 = new GradientDrawable();
        $this$onCreateView_u24lambda_u2435.setColor(0);
        $this$onCreateView_u24lambda_u2435.setCornerRadius(onCreateView$dp(density, 14));
        $this$onCreateView_u24lambda_u2435.setStroke(onCreateView$dp(density, 1), Color.parseColor("#334155"));
        final Button dismissBtn = new Button(ctx);
        dismissBtn.setText(achieved ? "Close" : "Maybe Later");
        dismissBtn.setTextSize(13.0f);
        dismissBtn.setTextColor(-1);
        dismissBtn.setAllCaps(false);
        dismissBtn.setTypeface(Typeface.DEFAULT_BOLD);
        dismissBtn.setFocusable(true);
        dismissBtn.setBackground($this$onCreateView_u24lambda_u2435);
        dismissBtn.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                DonationDialogFragment.onCreateView$lambda$36$0($this$onCreateView_u24lambda_u2435, dismissBtn, density, view, z2);
            }
        });
        dismissBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.dismissAllowingStateLoss();
            }
        });
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u2436_u242 = new LinearLayout.LayoutParams(-1, onCreateView$dp(density, 46));
        $this$onCreateView_u24lambda_u2436_u242.bottomMargin = onCreateView$dp(density, 10);
        dismissBtn.setLayoutParams($this$onCreateView_u24lambda_u2436_u242);
        btnSection.addView(dismissBtn);
        TextView $this$onCreateView_u24lambda_u2437 = new TextView(ctx);
        $this$onCreateView_u24lambda_u2437.setText("Not affiliated with CloudStream");
        $this$onCreateView_u24lambda_u2437.setTextSize(10.5f);
        $this$onCreateView_u24lambda_u2437.setTextColor(Color.parseColor("#CBD5E1"));
        $this$onCreateView_u24lambda_u2437.setGravity(17);
        $this$onCreateView_u24lambda_u2437.setTypeface(null, 2);
        $this$onCreateView_u24lambda_u2437.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        btnSection.addView($this$onCreateView_u24lambda_u2437);
        root.addView(btnSection);
        if (achieved) {
            final Ref.IntRef secondsLeft = new Ref.IntRef();
            secondsLeft.element = 5;
            dismissBtn.setText("Close (" + secondsLeft.element + ")");
            final Handler handler = new Handler(Looper.getMainLooper());
            final ?? r12 = new Runnable() { // from class: com.phisher98.donation.DonationDialogFragment$onCreateView$ticker$1
                @Override // java.lang.Runnable
                public void run() {
                    secondsLeft.element--;
                    if (secondsLeft.element <= 0) {
                        if (this.isAdded()) {
                            this.dismissAllowingStateLoss();
                        }
                    } else {
                        dismissBtn.setText("Close (" + secondsLeft.element + ")");
                        handler.postDelayed(this, 1000L);
                    }
                }
            };
            handler.postDelayed((Runnable) r12, 1000L);
            dismissBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DonationDialogFragment.onCreateView$lambda$38(handler, r12, this, view);
                }
            });
        }
        return root;
    }

    private static final int onCreateView$dp(float density, int v) {
        return (int) (v * density);
    }

    private static final float onCreateView$dp$0(float density, float v) {
        return v * density;
    }

    private static final LinearLayout onCreateView$statChip(Context ctx, float density, String icon, String label, String color) {
        LinearLayout chip = new LinearLayout(ctx);
        chip.setOrientation(0);
        chip.setGravity(16);
        chip.setPadding(onCreateView$dp(density, 10), onCreateView$dp(density, 6), onCreateView$dp(density, 12), onCreateView$dp(density, 6));
        GradientDrawable $this$onCreateView_u24statChip_u24lambda_u2410_u240 = new GradientDrawable();
        $this$onCreateView_u24statChip_u24lambda_u2410_u240.setColor(Color.parseColor("#1A1F2E"));
        $this$onCreateView_u24statChip_u24lambda_u2410_u240.setCornerRadius(onCreateView$dp(density, 8));
        $this$onCreateView_u24statChip_u24lambda_u2410_u240.setStroke(onCreateView$dp(density, 1), Color.parseColor("#252B3B"));
        chip.setBackground($this$onCreateView_u24statChip_u24lambda_u2410_u240);
        LinearLayout.LayoutParams $this$onCreateView_u24statChip_u24lambda_u2410_u241 = new LinearLayout.LayoutParams(-2, -2);
        $this$onCreateView_u24statChip_u24lambda_u2410_u241.rightMargin = onCreateView$dp(density, 8);
        chip.setLayoutParams($this$onCreateView_u24statChip_u24lambda_u2410_u241);
        TextView $this$onCreateView_u24statChip_u24lambda_u2411 = new TextView(ctx);
        $this$onCreateView_u24statChip_u24lambda_u2411.setText(icon);
        $this$onCreateView_u24statChip_u24lambda_u2411.setTextSize(13.0f);
        LinearLayout.LayoutParams $this$onCreateView_u24statChip_u24lambda_u2411_u240 = new LinearLayout.LayoutParams(-2, -2);
        $this$onCreateView_u24statChip_u24lambda_u2411_u240.rightMargin = onCreateView$dp(density, 5);
        $this$onCreateView_u24statChip_u24lambda_u2411.setLayoutParams($this$onCreateView_u24statChip_u24lambda_u2411_u240);
        TextView $this$onCreateView_u24statChip_u24lambda_u2412 = new TextView(ctx);
        $this$onCreateView_u24statChip_u24lambda_u2412.setText(label);
        $this$onCreateView_u24statChip_u24lambda_u2412.setTextSize(11.5f);
        $this$onCreateView_u24statChip_u24lambda_u2412.setTypeface(Typeface.DEFAULT_BOLD);
        $this$onCreateView_u24statChip_u24lambda_u2412.setTextColor(Color.parseColor(color));
        chip.addView($this$onCreateView_u24statChip_u24lambda_u2411);
        chip.addView($this$onCreateView_u24statChip_u24lambda_u2412);
        return chip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$30$0(GradientDrawable $primaryBg, View view, boolean hasFocus) {
        $primaryBg.setAlpha(hasFocus ? 200 : 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$30$1(DonationDialogFragment this$0, Context $ctx, View it) {
        this$0.openUrl($ctx, this$0.config.getPrimaryDonateUrl());
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$32$0(GradientDrawable $adBg, Button $this_apply, float $density, View view, boolean hasFocus) {
        $adBg.setStroke(onCreateView$dp($density, 1), hasFocus ? Color.parseColor("#60A5FA") : Color.parseColor("#2D3748"));
        $this_apply.setTextColor(hasFocus ? -1 : Color.parseColor("#93C5FD"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$32$1(DonationDialogFragment this$0, Context $ctx, View it) {
        this$0.openUrl($ctx, this$0.config.getAdSupportUrl());
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$34$0(GradientDrawable $secBg, View view, boolean hasFocus) {
        $secBg.setColor(hasFocus ? Color.parseColor("#252B3B") : Color.parseColor("#1A1F2E"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$34$1(DonationDialogFragment this$0, Context $ctx, View it) {
        this$0.openUrl($ctx, this$0.config.getSecondaryDonateUrl());
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$36$0(GradientDrawable $dismissBg, Button $this_apply, float $density, View view, boolean hasFocus) {
        $dismissBg.setStroke(onCreateView$dp($density, 1), hasFocus ? Color.parseColor("#94A3B8") : Color.parseColor("#334155"));
        $this_apply.setTextColor(-1);
    }

    static final void onCreateView$lambda$38(Handler $handler, DonationDialogFragment$onCreateView$ticker$1 $ticker, DonationDialogFragment this$0, View it) {
        $handler.removeCallbacks($ticker);
        this$0.dismissAllowingStateLoss();
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        DonationManager.INSTANCE.setDialogShowing(false);
        Function0<Unit> function0 = this.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        DonationManager.INSTANCE.setDialogShowing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(Context context, String url) {
        try {
            Result.Companion companion = Result.Companion;
            DonationDialogFragment donationDialogFragment = this;
            Uri uri = Uri.parse(url);
            Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setFlags(268435456);
            context.startActivity(intent);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
