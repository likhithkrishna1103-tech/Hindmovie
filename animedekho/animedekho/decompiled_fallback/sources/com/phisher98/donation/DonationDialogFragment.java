package com.phisher98.donation;

/* JADX INFO: compiled from: DonationDialogFragment.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017b\u0010\b\u0014\u0012\f\b\u0015\u0012\b\b\fJ\u0004\b\b(\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/phisher98/donation/DonationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "config", "Lcom/phisher98/donation/DonationConfig;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/donation/DonationConfig;Lkotlin/jvm/functions/Function0;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Landroid/annotation/SuppressLint;", "value", "SetTextI18n", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroy", "openUrl", "context", "Landroid/content/Context;", "url", "", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.jvm.internal.SourceDebugExtension({"SMAP\nDonationDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationDialogFragment.kt\ncom/phisher98/donation/DonationDialogFragment\n+ 2 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,580:1\n27#2:581\n432#3:582\n432#3:583\n432#3:584\n432#3:585\n432#3:587\n432#3:588\n432#3:589\n432#3:590\n432#3:591\n432#3:592\n432#3:593\n432#3:594\n432#3:595\n432#3:596\n432#3:597\n432#3:598\n432#3:599\n432#3:600\n432#3:601\n432#3:602\n432#3:603\n432#3:604\n432#3:605\n432#3:606\n432#3:607\n432#3:608\n432#3:609\n432#3:610\n432#3:612\n432#3:613\n432#3:614\n432#3:615\n432#3:616\n432#3:617\n432#3:618\n1#4:586\n29#5:611\n*S KotlinDebug\n*F\n+ 1 DonationDialogFragment.kt\ncom/phisher98/donation/DonationDialogFragment\n*L\n37#1:581\n71#1:582\n73#1:583\n87#1:584\n88#1:585\n110#1:587\n113#1:588\n115#1:589\n131#1:590\n134#1:591\n161#1:592\n257#1:593\n260#1:594\n278#1:595\n320#1:596\n325#1:597\n339#1:598\n351#1:599\n352#1:600\n377#1:601\n408#1:602\n410#1:603\n442#1:604\n447#1:605\n469#1:606\n471#1:607\n476#1:608\n498#1:609\n523#1:610\n186#1:612\n188#1:613\n207#1:614\n452#1:615\n453#1:616\n481#1:617\n509#1:618\n573#1:611\n*E\n"})
public final class DonationDialogFragment extends androidx.fragment.app.DialogFragment {

    @org.jetbrains.annotations.NotNull
    private final com.phisher98.donation.DonationConfig config;

    @org.jetbrains.annotations.Nullable
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onDismissCallback;

    public static /* synthetic */ void $r8$lambda$92ZEL4UNEZ5MB44uNN3cPMZzIrM(com.phisher98.donation.DonationDialogFragment r0, android.view.View r1) {
            onCreateView$lambda$36$1(r0, r1)
            return
    }

    public static /* synthetic */ void $r8$lambda$9bzumAfGVN2NfgZ5V33IbUKIadU(com.phisher98.donation.DonationDialogFragment r0, android.content.Context r1, android.view.View r2) {
            onCreateView$lambda$34$1(r0, r1, r2)
            return
    }

    /* JADX INFO: renamed from: $r8$lambda$OVXlSC2UGSaP-i4YQYi9nuAWLlA, reason: not valid java name */
    public static /* synthetic */ void m0$r8$lambda$OVXlSC2UGSaPi4YQYi9nuAWLlA(com.phisher98.donation.DonationDialogFragment r0, android.content.Context r1, android.view.View r2) {
            onCreateView$lambda$32$1(r0, r1, r2)
            return
    }

    /* JADX INFO: renamed from: $r8$lambda$YPjtKXIcIFJ_JgWpNejs6H-JI3U, reason: not valid java name */
    public static /* synthetic */ void m1$r8$lambda$YPjtKXIcIFJ_JgWpNejs6HJI3U(android.graphics.drawable.GradientDrawable r0, android.view.View r1, boolean r2) {
            onCreateView$lambda$34$0(r0, r1, r2)
            return
    }

    public static /* synthetic */ void $r8$lambda$dP9afBU5760z64ly60ugs0vDk7I(android.graphics.drawable.GradientDrawable r0, android.widget.Button r1, float r2, android.view.View r3, boolean r4) {
            onCreateView$lambda$32$0(r0, r1, r2, r3, r4)
            return
    }

    public static /* synthetic */ void $r8$lambda$h2nkKHnO_X55Q_SxVufNyEUsOMU(android.graphics.drawable.GradientDrawable r0, android.widget.Button r1, float r2, android.view.View r3, boolean r4) {
            onCreateView$lambda$36$0(r0, r1, r2, r3, r4)
            return
    }

    /* JADX INFO: renamed from: $r8$lambda$pbSHhNM2BwLEa-QG_BAqhU8jUxE, reason: not valid java name */
    public static /* synthetic */ void m2$r8$lambda$pbSHhNM2BwLEaQG_BAqhU8jUxE(com.phisher98.donation.DonationDialogFragment r0, android.content.Context r1, android.view.View r2) {
            onCreateView$lambda$4$1(r0, r1, r2)
            return
    }

    public static /* synthetic */ void $r8$lambda$tI_4fZy8vfQ7K7yrFlAKVDQJ40E(android.graphics.drawable.GradientDrawable r0, android.view.View r1, boolean r2) {
            onCreateView$lambda$30$0(r0, r1, r2)
            return
    }

    public static /* synthetic */ void $r8$lambda$xvtk47aWFZwSlfxOaOdv7Qvzq8Y(com.phisher98.donation.DonationDialogFragment r0, android.content.Context r1, android.view.View r2) {
            onCreateView$lambda$30$1(r0, r1, r2)
            return
    }

    public DonationDialogFragment(@org.jetbrains.annotations.NotNull com.phisher98.donation.DonationConfig r1, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r2) {
            r0 = this;
            r0.<init>()
            r0.config = r1
            r0.onDismissCallback = r2
            return
    }

    public /* synthetic */ DonationDialogFragment(com.phisher98.donation.DonationConfig r1, kotlin.jvm.functions.Function0 r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L5
            r2 = 0
        L5:
            r0.<init>(r1, r2)
            return
    }

    private static final int onCreateView$dp(float r1, int r2) {
            float r0 = (float) r2
            float r0 = r0 * r1
            int r0 = (int) r0
            return r0
    }

    private static final float onCreateView$dp$0(float r1, float r2) {
            float r0 = r2 * r1
            return r0
    }

    private static final void onCreateView$lambda$30$0(android.graphics.drawable.GradientDrawable r0, android.view.View r1, boolean r2) {
            if (r2 == 0) goto L5
            r1 = 200(0xc8, float:2.8E-43)
            goto L7
        L5:
            r1 = 255(0xff, float:3.57E-43)
        L7:
            r0.setAlpha(r1)
            return
    }

    private static final void onCreateView$lambda$30$1(com.phisher98.donation.DonationDialogFragment r1, android.content.Context r2, android.view.View r3) {
            com.phisher98.donation.DonationConfig r0 = r1.config
            java.lang.String r0 = r0.getPrimaryDonateUrl()
            r1.openUrl(r2, r0)
            r1.dismissAllowingStateLoss()
            return
    }

    private static final void onCreateView$lambda$32$0(android.graphics.drawable.GradientDrawable r3, android.widget.Button r4, float r5, android.view.View r6, boolean r7) {
            r6 = 1
            int r6 = onCreateView$dp(r5, r6)
            if (r7 == 0) goto Lf
            java.lang.String r0 = "#60A5FA"
            r1 = 0
            int r0 = android.graphics.Color.parseColor(r0)
            goto L17
        Lf:
            java.lang.String r0 = "#2D3748"
            r1 = 0
            int r2 = android.graphics.Color.parseColor(r0)
            r0 = r2
        L17:
            r3.setStroke(r6, r0)
            if (r7 == 0) goto L1e
            r6 = -1
            goto L26
        L1e:
            java.lang.String r6 = "#93C5FD"
            r0 = 0
            int r1 = android.graphics.Color.parseColor(r6)
            r6 = r1
        L26:
            r4.setTextColor(r6)
            return
    }

    private static final void onCreateView$lambda$32$1(com.phisher98.donation.DonationDialogFragment r1, android.content.Context r2, android.view.View r3) {
            com.phisher98.donation.DonationConfig r0 = r1.config
            java.lang.String r0 = r0.getAdSupportUrl()
            r1.openUrl(r2, r0)
            r1.dismissAllowingStateLoss()
            return
    }

    private static final void onCreateView$lambda$34$0(android.graphics.drawable.GradientDrawable r2, android.view.View r3, boolean r4) {
            if (r4 == 0) goto La
            java.lang.String r3 = "#252B3B"
            r0 = 0
            int r3 = android.graphics.Color.parseColor(r3)
            goto L12
        La:
            java.lang.String r3 = "#1A1F2E"
            r0 = 0
            int r1 = android.graphics.Color.parseColor(r3)
            r3 = r1
        L12:
            r2.setColor(r3)
            return
    }

    private static final void onCreateView$lambda$34$1(com.phisher98.donation.DonationDialogFragment r1, android.content.Context r2, android.view.View r3) {
            com.phisher98.donation.DonationConfig r0 = r1.config
            java.lang.String r0 = r0.getSecondaryDonateUrl()
            r1.openUrl(r2, r0)
            r1.dismissAllowingStateLoss()
            return
    }

    private static final void onCreateView$lambda$36$0(android.graphics.drawable.GradientDrawable r3, android.widget.Button r4, float r5, android.view.View r6, boolean r7) {
            r6 = 1
            int r6 = onCreateView$dp(r5, r6)
            if (r7 == 0) goto Lf
            java.lang.String r0 = "#94A3B8"
            r1 = 0
            int r0 = android.graphics.Color.parseColor(r0)
            goto L17
        Lf:
            java.lang.String r0 = "#334155"
            r1 = 0
            int r2 = android.graphics.Color.parseColor(r0)
            r0 = r2
        L17:
            r3.setStroke(r6, r0)
            r6 = -1
            r4.setTextColor(r6)
            return
    }

    private static final void onCreateView$lambda$36$1(com.phisher98.donation.DonationDialogFragment r0, android.view.View r1) {
            r0.dismissAllowingStateLoss()
            return
    }

    static final void onCreateView$lambda$38(android.os.Handler r1, com.phisher98.donation.DonationDialogFragment$onCreateView$ticker$1 r2, com.phisher98.donation.DonationDialogFragment r3, android.view.View r4) {
            r0 = r2
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r1.removeCallbacks(r0)
            r3.dismissAllowingStateLoss()
            return
    }

    private static final void onCreateView$lambda$4$1(com.phisher98.donation.DonationDialogFragment r1, android.content.Context r2, android.view.View r3) {
            java.lang.String r0 = "https://github.com/phisher98"
            r1.openUrl(r2, r0)
            return
    }

    private static final android.widget.LinearLayout onCreateView$statChip(android.content.Context r10, float r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            r0.<init>(r10)
            r1 = r0
            r2 = 0
            r3 = 0
            r1.setOrientation(r3)
            r3 = 16
            r1.setGravity(r3)
            r3 = 10
            int r3 = onCreateView$dp(r11, r3)
            r4 = 6
            int r5 = onCreateView$dp(r11, r4)
            r6 = 12
            int r6 = onCreateView$dp(r11, r6)
            int r4 = onCreateView$dp(r11, r4)
            r1.setPadding(r3, r5, r6, r4)
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r4 = r3
            r5 = 0
            java.lang.String r6 = "#1A1F2E"
            r7 = 0
            int r6 = android.graphics.Color.parseColor(r6)
            r4.setColor(r6)
            r6 = 8
            int r7 = onCreateView$dp(r11, r6)
            float r7 = (float) r7
            r4.setCornerRadius(r7)
            r7 = 1
            int r7 = onCreateView$dp(r11, r7)
            java.lang.String r8 = "#252B3B"
            r9 = 0
            int r8 = android.graphics.Color.parseColor(r8)
            r4.setStroke(r7, r8)
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
            r1.setBackground(r3)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r4 = -2
            r3.<init>(r4, r4)
            r5 = r3
            r7 = 0
            int r6 = onCreateView$dp(r11, r6)
            r5.rightMargin = r6
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            r1.setLayoutParams(r3)
            android.widget.TextView r1 = new android.widget.TextView
            r1.<init>(r10)
            r2 = r1
            r3 = 0
            r5 = r12
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
            r5 = 1095761920(0x41500000, float:13.0)
            r2.setTextSize(r5)
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r5.<init>(r4, r4)
            r4 = r5
            r6 = 0
            r7 = 5
            int r7 = onCreateView$dp(r11, r7)
            r4.rightMargin = r7
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r2.setLayoutParams(r5)
            android.widget.TextView r2 = new android.widget.TextView
            r2.<init>(r10)
            r3 = r2
            r4 = 0
            r5 = r13
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
            r5 = 1094189056(0x41380000, float:11.5)
            r3.setTextSize(r5)
            android.graphics.Typeface r5 = android.graphics.Typeface.DEFAULT_BOLD
            r3.setTypeface(r5)
            r5 = r14
            r6 = 0
            int r5 = android.graphics.Color.parseColor(r5)
            r3.setTextColor(r5)
            r3 = r1
            android.view.View r3 = (android.view.View) r3
            r0.addView(r3)
            r3 = r2
            android.view.View r3 = (android.view.View) r3
            r0.addView(r3)
            return r0
    }

    private final void openUrl(android.content.Context r9, java.lang.String r10) {
            r8 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L2b
            r0 = r8
            com.phisher98.donation.DonationDialogFragment r0 = (com.phisher98.donation.DonationDialogFragment) r0     // Catch: java.lang.Throwable -> L2b
            r1 = 0
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> L2b
            java.lang.String r3 = "android.intent.action.VIEW"
            r4 = r10
            r5 = 0
            android.net.Uri r6 = android.net.Uri.parse(r4)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r7 = "Uri.parse(this)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)     // Catch: java.lang.Throwable -> L2b
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L2b
            r3 = r2
            r4 = 0
            r5 = 268435456(0x10000000, float:2.524355E-29)
            r3.setFlags(r5)     // Catch: java.lang.Throwable -> L2b
            r9.startActivity(r2)     // Catch: java.lang.Throwable -> L2b
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L2b
            kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L2b
            goto L35
        L2b:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.constructor-impl(r0)
        L35:
            return
    }

    @org.jetbrains.annotations.NotNull
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable android.os.Bundle r7) {
            r6 = this;
            android.app.Dialog r0 = super.onCreateDialog(r7)
            r1 = 1
            r0.requestWindowFeature(r1)
            android.view.Window r1 = r0.getWindow()
            if (r1 == 0) goto L23
            r2 = 0
            r3 = 0
            r4 = 0
            android.graphics.drawable.ColorDrawable r5 = new android.graphics.drawable.ColorDrawable
            r5.<init>(r3)
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
            r1.setBackgroundDrawable(r5)
            r3 = 1060320051(0x3f333333, float:0.7)
            r1.setDimAmount(r3)
        L23:
            return r0
    }

    @android.annotation.SuppressLint({"SetTextI18n"})
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull android.view.LayoutInflater r46, @org.jetbrains.annotations.Nullable android.view.ViewGroup r47, @org.jetbrains.annotations.Nullable android.os.Bundle r48) {
            r45 = this;
            r0 = r45
            android.content.Context r1 = r0.requireContext()
            android.content.res.Resources r2 = r1.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.density
            com.phisher98.donation.DonationConfig r3 = r0.config
            boolean r3 = r3.isGoalAchieved()
            android.widget.LinearLayout r4 = new android.widget.LinearLayout
            r4.<init>(r1)
            r5 = r4
            r6 = 0
            r7 = 1
            r5.setOrientation(r7)
            android.graphics.drawable.GradientDrawable r8 = new android.graphics.drawable.GradientDrawable
            r8.<init>()
            r9 = r8
            r10 = 0
            java.lang.String r11 = "#13161F"
            r12 = 0
            int r11 = android.graphics.Color.parseColor(r11)
            r9.setColor(r11)
            r11 = 22
            int r11 = onCreateView$dp(r2, r11)
            float r11 = (float) r11
            r9.setCornerRadius(r11)
            int r11 = onCreateView$dp(r2, r7)
            java.lang.String r12 = "#252B3B"
            r13 = 0
            int r12 = android.graphics.Color.parseColor(r12)
            r9.setStroke(r11, r12)
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            r5.setBackground(r8)
            android.view.ViewGroup$LayoutParams r8 = new android.view.ViewGroup$LayoutParams
            r9 = -1
            r10 = -2
            r8.<init>(r9, r10)
            r5.setLayoutParams(r8)
            android.widget.LinearLayout r5 = new android.widget.LinearLayout
            r5.<init>(r1)
            r6 = r5
            r8 = 0
            r6.setOrientation(r7)
            r11 = 20
            int r12 = onCreateView$dp(r2, r11)
            int r13 = onCreateView$dp(r2, r11)
            int r14 = onCreateView$dp(r2, r11)
            r15 = 18
            int r15 = onCreateView$dp(r2, r15)
            r6.setPadding(r12, r13, r14, r15)
            android.graphics.drawable.GradientDrawable r12 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r13 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            r14 = 2
            r15 = 0
            if (r3 == 0) goto L9e
            int[] r11 = new int[r14]
            java.lang.String r17 = "#1A2E1A"
            r18 = 0
            int r17 = android.graphics.Color.parseColor(r17)
            r11[r15] = r17
            java.lang.String r17 = "#13161F"
            r18 = 0
            int r17 = android.graphics.Color.parseColor(r17)
            r11[r7] = r17
            goto Lb5
        L9e:
            int[] r11 = new int[r14]
            java.lang.String r17 = "#131826"
            r18 = 0
            int r17 = android.graphics.Color.parseColor(r17)
            r11[r15] = r17
            java.lang.String r17 = "#13161F"
            r18 = 0
            int r17 = android.graphics.Color.parseColor(r17)
            r11[r7] = r17
        Lb5:
            r12.<init>(r13, r11)
            r11 = r12
            r13 = 0
            r17 = 2
            r14 = 1102053376(0x41b00000, float:22.0)
            float r18 = onCreateView$dp$0(r2, r14)
            float r19 = onCreateView$dp$0(r2, r14)
            float r20 = onCreateView$dp$0(r2, r14)
            float r21 = onCreateView$dp$0(r2, r14)
            r14 = 8
            r23 = 1
            float[] r7 = new float[r14]
            r7[r15] = r18
            r7[r23] = r19
            r7[r17] = r20
            r14 = 3
            r7[r14] = r21
            r20 = 4
            r14 = 0
            r7[r20] = r14
            r21 = 0
            r14 = 5
            r7[r14] = r21
            r14 = 6
            r7[r14] = r21
            r24 = 7
            r7[r24] = r21
            r11.setCornerRadii(r7)
            android.graphics.drawable.Drawable r12 = (android.graphics.drawable.Drawable) r12
            r6.setBackground(r12)
            android.widget.LinearLayout$LayoutParams r7 = new android.widget.LinearLayout$LayoutParams
            r7.<init>(r9, r10)
            android.view.ViewGroup$LayoutParams r7 = (android.view.ViewGroup.LayoutParams) r7
            r6.setLayoutParams(r7)
            android.widget.LinearLayout r6 = new android.widget.LinearLayout
            r6.<init>(r1)
            r7 = r6
            r8 = 0
            r7.setOrientation(r15)
            r11 = 16
            r7.setGravity(r11)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            r12.<init>(r9, r10)
            r13 = r12
            r24 = 0
            r11 = 14
            int r9 = onCreateView$dp(r2, r11)
            r13.bottomMargin = r9
            android.view.ViewGroup$LayoutParams r12 = (android.view.ViewGroup.LayoutParams) r12
            r7.setLayoutParams(r12)
            android.widget.TextView r7 = new android.widget.TextView
            r7.<init>(r1)
            r8 = r7
            r9 = 0
            java.lang.String r12 = "⚡ Phisher Repo  •  phisher98 ↗"
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r8.setText(r12)
            r12 = 1093664768(0x41300000, float:11.0)
            r8.setTextSize(r12)
            android.graphics.Typeface r13 = android.graphics.Typeface.DEFAULT_BOLD
            r8.setTypeface(r13)
            java.lang.String r13 = "#93C5FD"
            r24 = 0
            int r13 = android.graphics.Color.parseColor(r13)
            r8.setTextColor(r13)
            r13 = 10
            int r11 = onCreateView$dp(r2, r13)
            r12 = 4
            int r15 = onCreateView$dp(r2, r12)
            int r10 = onCreateView$dp(r2, r13)
            int r13 = onCreateView$dp(r2, r12)
            r8.setPadding(r11, r15, r10, r13)
            android.graphics.drawable.GradientDrawable r10 = new android.graphics.drawable.GradientDrawable
            r10.<init>()
            r11 = r10
            r12 = 0
            java.lang.String r13 = "#1E293B"
            r15 = 0
            int r13 = android.graphics.Color.parseColor(r13)
            r11.setColor(r13)
            int r13 = onCreateView$dp(r2, r14)
            float r13 = (float) r13
            r11.setCornerRadius(r13)
            r13 = 1
            int r15 = onCreateView$dp(r2, r13)
            java.lang.String r13 = "#334155"
            r28 = 0
            int r13 = android.graphics.Color.parseColor(r13)
            r11.setStroke(r15, r13)
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10
            r8.setBackground(r10)
            r13 = 1
            r8.setClickable(r13)
            r8.setFocusable(r13)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda0 r10 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda0
            r10.<init>(r0, r1)
            r8.setOnClickListener(r10)
            android.widget.LinearLayout$LayoutParams r10 = new android.widget.LinearLayout$LayoutParams
            r11 = -2
            r10.<init>(r11, r11)
            android.view.ViewGroup$LayoutParams r10 = (android.view.ViewGroup.LayoutParams) r10
            r8.setLayoutParams(r10)
            r8 = r7
            android.view.View r8 = (android.view.View) r8
            r6.addView(r8)
            android.view.View r8 = new android.view.View
            r8.<init>(r1)
            r9 = r8
            r10 = 0
            android.widget.LinearLayout$LayoutParams r11 = new android.widget.LinearLayout$LayoutParams
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r15 = 1
            r11.<init>(r13, r15, r12)
            android.view.ViewGroup$LayoutParams r11 = (android.view.ViewGroup.LayoutParams) r11
            r9.setLayoutParams(r11)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            r6.addView(r8)
            android.widget.TextView r8 = new android.widget.TextView
            r8.<init>(r1)
            r9 = r8
            r10 = 0
            com.phisher98.donation.DonationConfig r11 = r0.config
            java.lang.String r11 = r11.getMonth()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r9.setText(r11)
            r11 = 1093140480(0x41280000, float:10.5)
            r9.setTextSize(r11)
            java.lang.String r11 = "#CBD5E1"
            r13 = 0
            int r11 = android.graphics.Color.parseColor(r11)
            r9.setTextColor(r11)
            r11 = 8
            int r13 = onCreateView$dp(r2, r11)
            r15 = 3
            int r12 = onCreateView$dp(r2, r15)
            int r14 = onCreateView$dp(r2, r11)
            int r11 = onCreateView$dp(r2, r15)
            r9.setPadding(r13, r12, r14, r11)
            android.graphics.drawable.GradientDrawable r11 = new android.graphics.drawable.GradientDrawable
            r11.<init>()
            r12 = r11
            r13 = 0
            java.lang.String r14 = "#1A1F2E"
            r15 = 0
            int r14 = android.graphics.Color.parseColor(r14)
            r12.setColor(r14)
            r14 = 5
            int r15 = onCreateView$dp(r2, r14)
            float r14 = (float) r15
            r12.setCornerRadius(r14)
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11
            r9.setBackground(r11)
            r9 = r8
            android.view.View r9 = (android.view.View) r9
            r6.addView(r9)
            r9 = r6
            android.view.View r9 = (android.view.View) r9
            r5.addView(r9)
            android.widget.TextView r9 = new android.widget.TextView
            r9.<init>(r1)
            r10 = r9
            r11 = 0
            if (r3 == 0) goto L245
            java.lang.String r12 = "🎉 Goal Achieved!"
            goto L247
        L245:
            java.lang.String r12 = "⚡ Support Phisher Repo"
        L247:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r10.setText(r12)
            r12 = 1102053376(0x41b00000, float:22.0)
            r10.setTextSize(r12)
            r12 = -1
            r10.setTextColor(r12)
            android.graphics.Typeface r13 = android.graphics.Typeface.DEFAULT_BOLD
            r10.setTypeface(r13)
            android.widget.LinearLayout$LayoutParams r13 = new android.widget.LinearLayout$LayoutParams
            r14 = -2
            r13.<init>(r12, r14)
            r12 = r13
            r14 = 0
            r22 = r3
            r15 = 6
            int r3 = onCreateView$dp(r2, r15)
            r12.bottomMargin = r3
            android.view.ViewGroup$LayoutParams r13 = (android.view.ViewGroup.LayoutParams) r13
            r10.setLayoutParams(r13)
            r3 = r9
            android.view.View r3 = (android.view.View) r3
            r5.addView(r3)
            android.widget.TextView r3 = new android.widget.TextView
            r3.<init>(r1)
            r10 = r3
            r11 = 0
            if (r22 == 0) goto L289
            java.lang.String r12 = "The monthly maintenance goal is fully funded — thank you! 🙌"
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            goto L28d
        L289:
            java.lang.String r12 = "Keep 80+ free extensions alive. No ads, no paywalls — just community support."
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
        L28d:
            r10.setText(r12)
            r12 = 1095761920(0x41500000, float:13.0)
            r10.setTextSize(r12)
            java.lang.String r13 = "#94A3B8"
            r14 = 0
            int r13 = android.graphics.Color.parseColor(r13)
            r10.setTextColor(r13)
            r13 = 1068289229(0x3faccccd, float:1.35)
            r14 = 0
            r10.setLineSpacing(r14, r13)
            android.widget.LinearLayout$LayoutParams r13 = new android.widget.LinearLayout$LayoutParams
            r14 = -1
            r15 = -2
            r13.<init>(r14, r15)
            r14 = r13
            r15 = 0
            r29 = r3
            r12 = 16
            int r3 = onCreateView$dp(r2, r12)
            r14.bottomMargin = r3
            android.view.ViewGroup$LayoutParams r13 = (android.view.ViewGroup.LayoutParams) r13
            r10.setLayoutParams(r13)
            r3 = r29
            android.view.View r3 = (android.view.View) r3
            r5.addView(r3)
            android.widget.LinearLayout r3 = new android.widget.LinearLayout
            r3.<init>(r1)
            r10 = r3
            r11 = 0
            r13 = 0
            r10.setOrientation(r13)
            r12 = 16
            r10.setGravity(r12)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            r14 = -1
            r15 = -2
            r12.<init>(r14, r15)
            android.view.ViewGroup$LayoutParams r12 = (android.view.ViewGroup.LayoutParams) r12
            r10.setLayoutParams(r12)
            if (r22 == 0) goto L322
            java.lang.String r10 = "Goal Reached"
            java.lang.String r11 = "#4ADE80"
            java.lang.String r12 = "🏆"
            android.widget.LinearLayout r10 = onCreateView$statChip(r1, r2, r12, r10, r11)
            android.view.View r10 = (android.view.View) r10
            r3.addView(r10)
            com.phisher98.donation.DonationConfig r10 = r0.config
            int r10 = r10.getSupportersCount()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.StringBuilder r10 = r11.append(r10)
            java.lang.String r11 = " Supporters"
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "#93C5FD"
            java.lang.String r12 = "👥"
            android.widget.LinearLayout r10 = onCreateView$statChip(r1, r2, r12, r10, r11)
            android.view.View r10 = (android.view.View) r10
            r3.addView(r10)
            goto L340
        L322:
            java.lang.String r10 = "100% Free"
            java.lang.String r11 = "#4ADE80"
            java.lang.String r12 = "🔓"
            android.widget.LinearLayout r10 = onCreateView$statChip(r1, r2, r12, r10, r11)
            android.view.View r10 = (android.view.View) r10
            r3.addView(r10)
            java.lang.String r10 = "80+ Extensions"
            java.lang.String r11 = "#93C5FD"
            java.lang.String r12 = "🔧"
            android.widget.LinearLayout r10 = onCreateView$statChip(r1, r2, r12, r10, r11)
            android.view.View r10 = (android.view.View) r10
            r3.addView(r10)
        L340:
            r10 = r3
            android.view.View r10 = (android.view.View) r10
            r5.addView(r10)
            if (r22 != 0) goto L4e5
            r12 = 2
            kotlin.Triple[] r13 = new kotlin.Triple[r12]
            kotlin.Triple r12 = new kotlin.Triple
            java.lang.String r14 = "Goal Missed = Slower Updates:"
            java.lang.String r15 = "If target isn't met, fixes & updates will slow down."
            java.lang.String r11 = "⌛"
            r12.<init>(r11, r14, r15)
            r27 = 0
            r13[r27] = r12
            kotlin.Triple r11 = new kotlin.Triple
            java.lang.String r12 = "No Support = Extensions Die:"
            java.lang.String r14 = "Scrapers break and links die without ongoing maintenance."
            java.lang.String r15 = "💀"
            r11.<init>(r15, r12, r14)
            r15 = 1
            r13[r15] = r11
            java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r13)
            android.widget.LinearLayout r12 = new android.widget.LinearLayout
            r12.<init>(r1)
            r13 = r12
            r14 = 0
            r13.setOrientation(r15)
            android.widget.LinearLayout$LayoutParams r15 = new android.widget.LinearLayout$LayoutParams
            r32 = r3
            r3 = -2
            r10 = -1
            r15.<init>(r10, r3)
            r3 = r15
            r10 = 0
            r33 = r6
            r6 = 12
            int r6 = onCreateView$dp(r2, r6)
            r3.topMargin = r6
            android.view.ViewGroup$LayoutParams r15 = (android.view.ViewGroup.LayoutParams) r15
            r13.setLayoutParams(r15)
            java.util.Iterator r3 = r11.iterator()
        L39a:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L4d8
            java.lang.Object r6 = r3.next()
            kotlin.Triple r6 = (kotlin.Triple) r6
            java.lang.Object r10 = r6.component1()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r13 = r6.component2()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r6 = r6.component3()
            java.lang.String r6 = (java.lang.String) r6
            android.widget.LinearLayout r14 = new android.widget.LinearLayout
            r14.<init>(r1)
            r15 = r14
            r34 = 0
            r35 = r3
            r3 = 0
            r15.setOrientation(r3)
            r3 = 48
            r15.setGravity(r3)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r36 = r6
            r37 = r7
            r6 = -1
            r7 = -2
            r3.<init>(r6, r7)
            r6 = r3
            r7 = 0
            r38 = r3
            r39 = r7
            r3 = 5
            int r7 = onCreateView$dp(r2, r3)
            r6.bottomMargin = r7
            r3 = r38
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            r15.setLayoutParams(r3)
            android.widget.TextView r3 = new android.widget.TextView
            r3.<init>(r1)
            r6 = r3
            r7 = 0
            r15 = r10
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r6.setText(r15)
            r15 = 1094713344(0x41400000, float:12.0)
            r6.setTextSize(r15)
            android.widget.LinearLayout$LayoutParams r15 = new android.widget.LinearLayout$LayoutParams
            r34 = r3
            r3 = -2
            r15.<init>(r3, r3)
            r3 = r15
            r38 = 0
            r39 = r7
            r7 = 7
            int r7 = onCreateView$dp(r2, r7)
            r3.rightMargin = r7
            r40 = r8
            r7 = 1
            int r8 = onCreateView$dp(r2, r7)
            r3.topMargin = r8
            android.view.ViewGroup$LayoutParams r15 = (android.view.ViewGroup.LayoutParams) r15
            r6.setLayoutParams(r15)
            android.widget.TextView r3 = new android.widget.TextView
            r3.<init>(r1)
            r6 = r3
            r7 = 0
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>()
            r15 = r8
            r38 = 0
            r39 = r3
            int r3 = r15.length()
            r41 = r7
            r7 = r13
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.append(r7)
            android.text.style.StyleSpan r7 = new android.text.style.StyleSpan
            r42 = r8
            r8 = 1
            r7.<init>(r8)
            int r8 = r15.length()
            r43 = r9
            r9 = 33
            r15.setSpan(r7, r3, r8, r9)
            android.text.style.ForegroundColorSpan r7 = new android.text.style.ForegroundColorSpan
            java.lang.String r8 = "#E2E8F0"
            r30 = 0
            int r8 = android.graphics.Color.parseColor(r8)
            r7.<init>(r8)
            int r8 = r15.length()
            r15.setSpan(r7, r3, r8, r9)
            java.lang.String r7 = " "
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.append(r7)
            int r7 = r15.length()
            r8 = r36
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r15.append(r8)
            android.text.style.ForegroundColorSpan r8 = new android.text.style.ForegroundColorSpan
            java.lang.String r9 = "#94A3B8"
            r44 = 0
            int r9 = android.graphics.Color.parseColor(r9)
            r8.<init>(r9)
            int r9 = r15.length()
            r44 = r3
            r3 = 33
            r15.setSpan(r8, r7, r9, r3)
            r3 = r42
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6.setText(r3)
            r15 = 1094713344(0x41400000, float:12.0)
            r6.setTextSize(r15)
            r3 = 1067450368(0x3fa00000, float:1.25)
            r7 = 0
            r6.setLineSpacing(r7, r3)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            r15 = -2
            r3.<init>(r9, r15, r8)
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            r6.setLayoutParams(r3)
            r3 = r34
            android.view.View r3 = (android.view.View) r3
            r14.addView(r3)
            r3 = r39
            android.view.View r3 = (android.view.View) r3
            r14.addView(r3)
            r3 = r14
            android.view.View r3 = (android.view.View) r3
            r12.addView(r3)
            r3 = r35
            r7 = r37
            r8 = r40
            r9 = r43
            goto L39a
        L4d8:
            r37 = r7
            r40 = r8
            r43 = r9
            r3 = r12
            android.view.View r3 = (android.view.View) r3
            r5.addView(r3)
            goto L4ef
        L4e5:
            r32 = r3
            r33 = r6
            r37 = r7
            r40 = r8
            r43 = r9
        L4ef:
            r3 = r5
            android.view.View r3 = (android.view.View) r3
            r4.addView(r3)
            android.view.View r3 = new android.view.View
            r3.<init>(r1)
            r6 = r3
            r7 = 0
            java.lang.String r8 = "#1E2433"
            r9 = 0
            int r8 = android.graphics.Color.parseColor(r8)
            r6.setBackgroundColor(r8)
            android.widget.LinearLayout$LayoutParams r8 = new android.widget.LinearLayout$LayoutParams
            r13 = 1
            int r9 = onCreateView$dp(r2, r13)
            r14 = -1
            r8.<init>(r14, r9)
            android.view.ViewGroup$LayoutParams r8 = (android.view.ViewGroup.LayoutParams) r8
            r6.setLayoutParams(r8)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r4.addView(r3)
            android.widget.LinearLayout r3 = new android.widget.LinearLayout
            r3.<init>(r1)
            r6 = r3
            r7 = 0
            r13 = 1
            r6.setOrientation(r13)
            r8 = 20
            int r9 = onCreateView$dp(r2, r8)
            r12 = 16
            int r10 = onCreateView$dp(r2, r12)
            int r11 = onCreateView$dp(r2, r8)
            r12 = 4
            int r8 = onCreateView$dp(r2, r12)
            r6.setPadding(r9, r10, r11, r8)
            android.widget.LinearLayout$LayoutParams r8 = new android.widget.LinearLayout$LayoutParams
            r14 = -1
            r15 = -2
            r8.<init>(r14, r15)
            android.view.ViewGroup$LayoutParams r8 = (android.view.ViewGroup.LayoutParams) r8
            r6.setLayoutParams(r8)
            android.widget.LinearLayout r6 = new android.widget.LinearLayout
            r6.<init>(r1)
            r7 = r6
            r8 = 0
            r13 = 0
            r7.setOrientation(r13)
            r12 = 16
            r7.setGravity(r12)
            android.widget.LinearLayout$LayoutParams r9 = new android.widget.LinearLayout$LayoutParams
            r14 = -1
            r15 = -2
            r9.<init>(r14, r15)
            r10 = r9
            r11 = 0
            r12 = 10
            int r13 = onCreateView$dp(r2, r12)
            r10.bottomMargin = r13
            android.view.ViewGroup$LayoutParams r9 = (android.view.ViewGroup.LayoutParams) r9
            r7.setLayoutParams(r9)
            android.widget.TextView r7 = new android.widget.TextView
            r7.<init>(r1)
            r8 = r7
            r9 = 0
            if (r22 == 0) goto L586
            java.lang.String r10 = "Monthly Goal"
            goto L588
        L586:
            java.lang.String r10 = "Progress this month"
        L588:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r8.setText(r10)
            r15 = 1094713344(0x41400000, float:12.0)
            r8.setTextSize(r15)
            r14 = -1
            r8.setTextColor(r14)
            android.widget.LinearLayout$LayoutParams r10 = new android.widget.LinearLayout$LayoutParams
            r11 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r15 = -2
            r10.<init>(r13, r15, r11)
            android.view.ViewGroup$LayoutParams r10 = (android.view.ViewGroup.LayoutParams) r10
            r8.setLayoutParams(r10)
            r8 = r7
            android.view.View r8 = (android.view.View) r8
            r6.addView(r8)
            com.phisher98.donation.DonationConfig r8 = r0.config
            double r8 = r8.getCurrentAmount()
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r8 = r8 % r10
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L5bd
            r8 = 1
            goto L5be
        L5bd:
            r8 = 0
        L5be:
            com.phisher98.donation.DonationConfig r9 = r0.config
            if (r8 == 0) goto L5cc
            double r8 = r9.getCurrentAmount()
            int r8 = (int) r8
            java.lang.String r8 = java.lang.String.valueOf(r8)
            goto L5ea
        L5cc:
            double r8 = r9.getCurrentAmount()
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r13 = 1
            java.lang.Object[] r9 = new java.lang.Object[r13]
            r27 = 0
            r9[r27] = r8
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r9, r13)
            java.lang.String r9 = "%.1f"
            java.lang.String r8 = java.lang.String.format(r9, r8)
            java.lang.String r9 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
        L5ea:
            com.phisher98.donation.DonationConfig r9 = r0.config
            double r9 = r9.getTargetAmount()
            int r9 = (int) r9
            java.lang.String r9 = java.lang.String.valueOf(r9)
            android.widget.TextView r10 = new android.widget.TextView
            r10.<init>(r1)
            r11 = r10
            r12 = 0
            android.text.SpannableStringBuilder r13 = new android.text.SpannableStringBuilder
            r13.<init>()
            r14 = r13
            r15 = 0
            r20 = r5
            int r5 = r14.length()
            r21 = r7
            com.phisher98.donation.DonationConfig r7 = r0.config
            java.lang.String r7 = r7.getCurrency()
            r31 = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r7 = r10.append(r7)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r14.append(r7)
            android.text.style.StyleSpan r7 = new android.text.style.StyleSpan
            r10 = 1
            r7.<init>(r10)
            int r10 = r14.length()
            r34 = r8
            r8 = 33
            r14.setSpan(r7, r5, r10, r8)
            android.text.style.ForegroundColorSpan r7 = new android.text.style.ForegroundColorSpan
            if (r22 == 0) goto L648
            java.lang.String r8 = "#4ADE80"
            r10 = 0
            int r8 = android.graphics.Color.parseColor(r8)
            goto L651
        L648:
            java.lang.String r8 = "#22C55E"
            r10 = 0
            int r35 = android.graphics.Color.parseColor(r8)
            r8 = r35
        L651:
            r7.<init>(r8)
            int r8 = r14.length()
            r10 = 33
            r14.setSpan(r7, r5, r8, r10)
            int r7 = r14.length()
            com.phisher98.donation.DonationConfig r8 = r0.config
            java.lang.String r8 = r8.getCurrency()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r35 = r5
            java.lang.String r5 = "  /  "
            java.lang.StringBuilder r5 = r10.append(r5)
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r5 = r5.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r14.append(r5)
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
            java.lang.String r8 = "#CBD5E1"
            r10 = 0
            int r8 = android.graphics.Color.parseColor(r8)
            r5.<init>(r8)
            int r8 = r14.length()
            r10 = 33
            r14.setSpan(r5, r7, r8, r10)
            r5 = r13
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r11.setText(r5)
            r5 = 1096810496(0x41600000, float:14.0)
            r11.setTextSize(r5)
            r5 = r31
            android.view.View r5 = (android.view.View) r5
            r6.addView(r5)
            r5 = r6
            android.view.View r5 = (android.view.View) r5
            r3.addView(r5)
            com.phisher98.donation.DonationConfig r5 = r0.config
            int r5 = r5.getProgressPercentage()
            r7 = 100
            r13 = 0
            int r5 = kotlin.ranges.RangesKt.coerceIn(r5, r13, r7)
            android.widget.LinearLayout r8 = new android.widget.LinearLayout
            r8.<init>(r1)
            r10 = r8
            r11 = 0
            r10.setOrientation(r13)
            r12 = 1120403456(0x42c80000, float:100.0)
            r10.setWeightSum(r12)
            android.graphics.drawable.GradientDrawable r12 = new android.graphics.drawable.GradientDrawable
            r12.<init>()
            r13 = r12
            r14 = 0
            java.lang.String r15 = "#1E2330"
            r30 = 0
            int r15 = android.graphics.Color.parseColor(r15)
            r13.setColor(r15)
            r15 = 6
            int r7 = onCreateView$dp(r2, r15)
            float r7 = (float) r7
            r13.setCornerRadius(r7)
            android.graphics.drawable.Drawable r12 = (android.graphics.drawable.Drawable) r12
            r10.setBackground(r12)
            r13 = 1
            r10.setClipToOutline(r13)
            android.widget.LinearLayout$LayoutParams r7 = new android.widget.LinearLayout$LayoutParams
            r12 = 12
            int r12 = onCreateView$dp(r2, r12)
            r14 = -1
            r7.<init>(r14, r12)
            r12 = r7
            r13 = 0
            r14 = 8
            int r14 = onCreateView$dp(r2, r14)
            r12.bottomMargin = r14
            android.view.ViewGroup$LayoutParams r7 = (android.view.ViewGroup.LayoutParams) r7
            r10.setLayoutParams(r7)
            if (r5 <= 0) goto L783
            android.view.View r7 = new android.view.View
            r7.<init>(r1)
            r10 = r7
            r11 = 0
            android.graphics.drawable.GradientDrawable r12 = new android.graphics.drawable.GradientDrawable
            android.graphics.drawable.GradientDrawable$Orientation r13 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            if (r22 == 0) goto L740
            r14 = 2
            int[] r15 = new int[r14]
            java.lang.String r14 = "#22C55E"
            r18 = 0
            int r14 = android.graphics.Color.parseColor(r14)
            r27 = 0
            r15[r27] = r14
            java.lang.String r14 = "#4ADE80"
            r18 = 0
            int r14 = android.graphics.Color.parseColor(r14)
            r23 = 1
            r15[r23] = r14
            goto L75c
        L740:
            r14 = 2
            int[] r15 = new int[r14]
            java.lang.String r14 = "#16A34A"
            r18 = 0
            int r14 = android.graphics.Color.parseColor(r14)
            r27 = 0
            r15[r27] = r14
            java.lang.String r14 = "#22C55E"
            r18 = 0
            int r14 = android.graphics.Color.parseColor(r14)
            r23 = 1
            r15[r23] = r14
        L75c:
            r12.<init>(r13, r15)
            r13 = r12
            r14 = 0
            r15 = 6
            int r15 = onCreateView$dp(r2, r15)
            float r15 = (float) r15
            r13.setCornerRadius(r15)
            android.graphics.drawable.Drawable r12 = (android.graphics.drawable.Drawable) r12
            r10.setBackground(r12)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            float r13 = (float) r5
            r14 = 0
            r15 = -1
            r12.<init>(r14, r15, r13)
            android.view.ViewGroup$LayoutParams r12 = (android.view.ViewGroup.LayoutParams) r12
            r10.setLayoutParams(r12)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r8.addView(r7)
        L783:
            r7 = 100
            if (r5 >= r7) goto L7a3
            android.view.View r7 = new android.view.View
            r7.<init>(r1)
            r10 = r7
            r11 = 0
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            int r13 = 100 - r5
            float r13 = (float) r13
            r14 = 0
            r15 = -1
            r12.<init>(r14, r15, r13)
            android.view.ViewGroup$LayoutParams r12 = (android.view.ViewGroup.LayoutParams) r12
            r10.setLayoutParams(r12)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r8.addView(r7)
        L7a3:
            r7 = r8
            android.view.View r7 = (android.view.View) r7
            r3.addView(r7)
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r1)
            r10 = r7
            r11 = 0
            r13 = 0
            r10.setOrientation(r13)
            r12 = 16
            r10.setGravity(r12)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            r14 = -1
            r15 = -2
            r12.<init>(r14, r15)
            r13 = r12
            r14 = 0
            r18 = r5
            r15 = 16
            int r5 = onCreateView$dp(r2, r15)
            r13.bottomMargin = r5
            android.view.ViewGroup$LayoutParams r12 = (android.view.ViewGroup.LayoutParams) r12
            r10.setLayoutParams(r12)
            android.widget.TextView r5 = new android.widget.TextView
            r5.<init>(r1)
            r10 = r5
            r11 = 0
            com.phisher98.donation.DonationConfig r12 = r0.config
            int r12 = r12.getProgressPercentage()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.StringBuilder r12 = r13.append(r12)
            java.lang.String r13 = "% funded"
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r10.setText(r12)
            r12 = 1093664768(0x41300000, float:11.0)
            r10.setTextSize(r12)
            android.graphics.Typeface r12 = android.graphics.Typeface.DEFAULT_BOLD
            r10.setTypeface(r12)
            if (r22 == 0) goto L80f
            java.lang.String r12 = "#4ADE80"
            r13 = 0
            int r12 = android.graphics.Color.parseColor(r12)
            goto L817
        L80f:
            java.lang.String r12 = "#22C55E"
            r13 = 0
            int r14 = android.graphics.Color.parseColor(r12)
            r12 = r14
        L817:
            r10.setTextColor(r12)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = 0
            r15 = -2
            r12.<init>(r14, r15, r13)
            android.view.ViewGroup$LayoutParams r12 = (android.view.ViewGroup.LayoutParams) r12
            r10.setLayoutParams(r12)
            r10 = r5
            android.view.View r10 = (android.view.View) r10
            r7.addView(r10)
            android.widget.TextView r10 = new android.widget.TextView
            r10.<init>(r1)
            r11 = r10
            r12 = 0
            com.phisher98.donation.DonationConfig r13 = r0.config
            if (r22 == 0) goto L85f
            int r13 = r13.getSupportersCount()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "🙌 "
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.StringBuilder r13 = r14.append(r13)
            java.lang.String r14 = " supporters"
            java.lang.StringBuilder r13 = r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r19 = r5
            goto L8a9
        L85f:
            int r13 = r13.getSupportersCount()
            if (r13 <= 0) goto L8a2
            com.phisher98.donation.DonationConfig r13 = r0.config
            int r13 = r13.getSupportersCount()
            com.phisher98.donation.DonationConfig r14 = r0.config
            int r14 = r14.getSupportersCount()
            r15 = 1
            if (r14 != r15) goto L877
            java.lang.String r14 = ""
            goto L879
        L877:
            java.lang.String r14 = "s"
        L879:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r19 = r5
            java.lang.String r5 = "🙌 "
            java.lang.StringBuilder r5 = r15.append(r5)
            java.lang.StringBuilder r5 = r5.append(r13)
            java.lang.String r13 = " supporter"
            java.lang.StringBuilder r5 = r5.append(r13)
            java.lang.StringBuilder r5 = r5.append(r14)
            java.lang.String r13 = " so far"
            java.lang.StringBuilder r5 = r5.append(r13)
            java.lang.String r5 = r5.toString()
            r13 = r5
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            goto L8a9
        L8a2:
            r19 = r5
            java.lang.String r5 = "🙌 Be the first!"
            r13 = r5
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
        L8a9:
            r11.setText(r13)
            r5 = 1093664768(0x41300000, float:11.0)
            r11.setTextSize(r5)
            r14 = -1
            r11.setTextColor(r14)
            r5 = r10
            android.view.View r5 = (android.view.View) r5
            r7.addView(r5)
            r5 = r7
            android.view.View r5 = (android.view.View) r5
            r3.addView(r5)
            r5 = r3
            android.view.View r5 = (android.view.View) r5
            r4.addView(r5)
            android.widget.LinearLayout r5 = new android.widget.LinearLayout
            r5.<init>(r1)
            r11 = r5
            r12 = 0
            r13 = 1
            r11.setOrientation(r13)
            r15 = 16
            int r13 = onCreateView$dp(r2, r15)
            r25 = r3
            r14 = 0
            int r3 = onCreateView$dp(r2, r14)
            int r14 = onCreateView$dp(r2, r15)
            int r15 = onCreateView$dp(r2, r15)
            r11.setPadding(r13, r3, r14, r15)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r14 = -1
            r15 = -2
            r3.<init>(r14, r15)
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            r11.setLayoutParams(r3)
            com.phisher98.donation.DonationConfig r3 = r0.config
            java.lang.String r3 = r3.getPrimaryDonateUrl()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 != 0) goto L9d9
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r11 = r3
            r12 = 0
            if (r22 == 0) goto L92d
            r14 = 2
            int[] r13 = new int[r14]
            java.lang.String r14 = "#16A34A"
            r15 = 0
            int r14 = android.graphics.Color.parseColor(r14)
            r27 = 0
            r13[r27] = r14
            java.lang.String r14 = "#15803D"
            r15 = 0
            int r14 = android.graphics.Color.parseColor(r14)
            r23 = 1
            r13[r23] = r14
            goto L947
        L92d:
            r14 = 2
            int[] r13 = new int[r14]
            java.lang.String r14 = "#4F46E5"
            r15 = 0
            int r14 = android.graphics.Color.parseColor(r14)
            r27 = 0
            r13[r27] = r14
            java.lang.String r14 = "#5865F2"
            r15 = 0
            int r14 = android.graphics.Color.parseColor(r14)
            r23 = 1
            r13[r23] = r14
        L947:
            r11.setColors(r13)
            android.graphics.drawable.GradientDrawable$Orientation r13 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            r11.setOrientation(r13)
            r13 = 14
            int r14 = onCreateView$dp(r2, r13)
            float r13 = (float) r14
            r11.setCornerRadius(r13)
            android.widget.Button r11 = new android.widget.Button
            r11.<init>(r1)
            r12 = r11
            r13 = 0
            com.phisher98.donation.DonationConfig r14 = r0.config
            java.lang.String r14 = r14.getPrimaryButtonText()
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r12.setText(r14)
            r14 = 1097859072(0x41700000, float:15.0)
            r12.setTextSize(r14)
            r14 = -1
            r12.setTextColor(r14)
            r14 = 0
            r12.setAllCaps(r14)
            android.graphics.Typeface r15 = android.graphics.Typeface.DEFAULT_BOLD
            r12.setTypeface(r15)
            r15 = 1
            r12.setFocusable(r15)
            r15 = r3
            android.graphics.drawable.Drawable r15 = (android.graphics.drawable.Drawable) r15
            r12.setBackground(r15)
            r16 = r6
            r15 = 20
            int r6 = onCreateView$dp(r2, r15)
            r26 = r7
            int r7 = onCreateView$dp(r2, r14)
            int r15 = onCreateView$dp(r2, r15)
            r28 = r8
            int r8 = onCreateView$dp(r2, r14)
            r12.setPadding(r6, r7, r15, r8)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda1 r6 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda1
            r6.<init>(r3)
            r12.setOnFocusChangeListener(r6)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda2 r6 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda2
            r6.<init>(r0, r1)
            r12.setOnClickListener(r6)
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r7 = 50
            int r7 = onCreateView$dp(r2, r7)
            r14 = -1
            r6.<init>(r14, r7)
            r7 = r6
            r8 = 0
            r14 = 10
            int r15 = onCreateView$dp(r2, r14)
            r7.bottomMargin = r15
            android.view.ViewGroup$LayoutParams r6 = (android.view.ViewGroup.LayoutParams) r6
            r12.setLayoutParams(r6)
            r6 = r11
            android.view.View r6 = (android.view.View) r6
            r5.addView(r6)
            goto L9df
        L9d9:
            r16 = r6
            r26 = r7
            r28 = r8
        L9df:
            com.phisher98.donation.DonationConfig r3 = r0.config
            java.lang.String r3 = r3.getAdSupportUrl()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 != 0) goto La76
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r6 = r3
            r7 = 0
            r13 = 0
            r6.setColor(r13)
            r13 = 14
            int r8 = onCreateView$dp(r2, r13)
            float r8 = (float) r8
            r6.setCornerRadius(r8)
            r13 = 1
            int r8 = onCreateView$dp(r2, r13)
            java.lang.String r11 = "#2D3748"
            r12 = 0
            int r11 = android.graphics.Color.parseColor(r11)
            r6.setStroke(r8, r11)
            android.widget.Button r6 = new android.widget.Button
            r6.<init>(r1)
            r7 = r6
            r8 = 0
            com.phisher98.donation.DonationConfig r11 = r0.config
            java.lang.String r11 = r11.getAdSupportButtonText()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r7.setText(r11)
            r11 = 1095761920(0x41500000, float:13.0)
            r7.setTextSize(r11)
            java.lang.String r11 = "#93C5FD"
            r12 = 0
            int r11 = android.graphics.Color.parseColor(r11)
            r7.setTextColor(r11)
            r13 = 0
            r7.setAllCaps(r13)
            r13 = 1
            r7.setFocusable(r13)
            r11 = r3
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11
            r7.setBackground(r11)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda3 r11 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda3
            r11.<init>(r3, r7, r2)
            r7.setOnFocusChangeListener(r11)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda4 r11 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda4
            r11.<init>(r0, r1)
            r7.setOnClickListener(r11)
            android.widget.LinearLayout$LayoutParams r11 = new android.widget.LinearLayout$LayoutParams
            r12 = 46
            int r12 = onCreateView$dp(r2, r12)
            r14 = -1
            r11.<init>(r14, r12)
            r12 = r11
            r13 = 0
            r14 = 10
            int r15 = onCreateView$dp(r2, r14)
            r12.bottomMargin = r15
            android.view.ViewGroup$LayoutParams r11 = (android.view.ViewGroup.LayoutParams) r11
            r7.setLayoutParams(r11)
            r7 = r6
            android.view.View r7 = (android.view.View) r7
            r5.addView(r7)
        La76:
            com.phisher98.donation.DonationConfig r3 = r0.config
            java.lang.String r3 = r3.getSecondaryDonateUrl()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 != 0) goto Lb13
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r6 = r3
            r7 = 0
            java.lang.String r8 = "#1A1F2E"
            r11 = 0
            int r8 = android.graphics.Color.parseColor(r8)
            r6.setColor(r8)
            r13 = 14
            int r8 = onCreateView$dp(r2, r13)
            float r8 = (float) r8
            r6.setCornerRadius(r8)
            r13 = 1
            int r8 = onCreateView$dp(r2, r13)
            java.lang.String r11 = "#2D3748"
            r12 = 0
            int r11 = android.graphics.Color.parseColor(r11)
            r6.setStroke(r8, r11)
            android.widget.Button r6 = new android.widget.Button
            r6.<init>(r1)
            r7 = r6
            r8 = 0
            com.phisher98.donation.DonationConfig r11 = r0.config
            java.lang.String r11 = r11.getSecondaryButtonText()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r7.setText(r11)
            r11 = 1095761920(0x41500000, float:13.0)
            r7.setTextSize(r11)
            java.lang.String r11 = "#CBD5E1"
            r12 = 0
            int r11 = android.graphics.Color.parseColor(r11)
            r7.setTextColor(r11)
            r13 = 0
            r7.setAllCaps(r13)
            r13 = 1
            r7.setFocusable(r13)
            r11 = r3
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11
            r7.setBackground(r11)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda5 r11 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda5
            r11.<init>(r3)
            r7.setOnFocusChangeListener(r11)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda6 r11 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda6
            r11.<init>(r0, r1)
            r7.setOnClickListener(r11)
            android.widget.LinearLayout$LayoutParams r11 = new android.widget.LinearLayout$LayoutParams
            r12 = 46
            int r12 = onCreateView$dp(r2, r12)
            r14 = -1
            r11.<init>(r14, r12)
            r12 = r11
            r13 = 0
            r14 = 10
            int r15 = onCreateView$dp(r2, r14)
            r12.bottomMargin = r15
            android.view.ViewGroup$LayoutParams r11 = (android.view.ViewGroup.LayoutParams) r11
            r7.setLayoutParams(r11)
            r7 = r6
            android.view.View r7 = (android.view.View) r7
            r5.addView(r7)
        Lb13:
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r6 = r3
            r7 = 0
            r13 = 0
            r6.setColor(r13)
            r13 = 14
            int r8 = onCreateView$dp(r2, r13)
            float r8 = (float) r8
            r6.setCornerRadius(r8)
            r13 = 1
            int r8 = onCreateView$dp(r2, r13)
            java.lang.String r11 = "#334155"
            r12 = 0
            int r11 = android.graphics.Color.parseColor(r11)
            r6.setStroke(r8, r11)
            android.widget.Button r6 = new android.widget.Button
            r6.<init>(r1)
            r7 = r6
            r8 = 0
            if (r22 == 0) goto Lb45
            java.lang.String r11 = "Close"
            goto Lb47
        Lb45:
            java.lang.String r11 = "Maybe Later"
        Lb47:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r7.setText(r11)
            r11 = 1095761920(0x41500000, float:13.0)
            r7.setTextSize(r11)
            r14 = -1
            r7.setTextColor(r14)
            r13 = 0
            r7.setAllCaps(r13)
            android.graphics.Typeface r11 = android.graphics.Typeface.DEFAULT_BOLD
            r7.setTypeface(r11)
            r13 = 1
            r7.setFocusable(r13)
            r11 = r3
            android.graphics.drawable.Drawable r11 = (android.graphics.drawable.Drawable) r11
            r7.setBackground(r11)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda7 r11 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda7
            r11.<init>(r3, r7, r2)
            r7.setOnFocusChangeListener(r11)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda8 r11 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda8
            r11.<init>(r0)
            r7.setOnClickListener(r11)
            android.widget.LinearLayout$LayoutParams r11 = new android.widget.LinearLayout$LayoutParams
            r12 = 46
            int r12 = onCreateView$dp(r2, r12)
            r14 = -1
            r11.<init>(r14, r12)
            r12 = r11
            r13 = 0
            r14 = 10
            int r14 = onCreateView$dp(r2, r14)
            r12.bottomMargin = r14
            android.view.ViewGroup$LayoutParams r11 = (android.view.ViewGroup.LayoutParams) r11
            r7.setLayoutParams(r11)
            r7 = r6
            android.view.View r7 = (android.view.View) r7
            r5.addView(r7)
            android.widget.TextView r7 = new android.widget.TextView
            r7.<init>(r1)
            r8 = r7
            r11 = 0
            java.lang.String r12 = "Not affiliated with CloudStream"
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r8.setText(r12)
            r12 = 1093140480(0x41280000, float:10.5)
            r8.setTextSize(r12)
            java.lang.String r12 = "#CBD5E1"
            r13 = 0
            int r12 = android.graphics.Color.parseColor(r12)
            r8.setTextColor(r12)
            r12 = 17
            r8.setGravity(r12)
            r12 = 0
            r14 = 2
            r8.setTypeface(r12, r14)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            r14 = -1
            r15 = -2
            r12.<init>(r14, r15)
            android.view.ViewGroup$LayoutParams r12 = (android.view.ViewGroup.LayoutParams) r12
            r8.setLayoutParams(r12)
            r8 = r7
            android.view.View r8 = (android.view.View) r8
            r5.addView(r8)
            r8 = r5
            android.view.View r8 = (android.view.View) r8
            r4.addView(r8)
            if (r22 == 0) goto Lc27
            kotlin.jvm.internal.Ref$IntRef r8 = new kotlin.jvm.internal.Ref$IntRef
            r8.<init>()
            r14 = 5
            r8.element = r14
            int r11 = r8.element
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Close ("
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.StringBuilder r11 = r12.append(r11)
            java.lang.String r12 = ")"
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r6.setText(r11)
            android.os.Handler r11 = new android.os.Handler
            android.os.Looper r12 = android.os.Looper.getMainLooper()
            r11.<init>(r12)
            com.phisher98.donation.DonationDialogFragment$onCreateView$ticker$1 r12 = new com.phisher98.donation.DonationDialogFragment$onCreateView$ticker$1
            r12.<init>(r8, r0, r6, r11)
            r13 = r12
            java.lang.Runnable r13 = (java.lang.Runnable) r13
            r14 = 1000(0x3e8, double:4.94E-321)
            r11.postDelayed(r13, r14)
            com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda9 r13 = new com.phisher98.donation.DonationDialogFragment$$ExternalSyntheticLambda9
            r13.<init>(r11, r12, r0)
            r6.setOnClickListener(r13)
        Lc27:
            r8 = r4
            android.view.View r8 = (android.view.View) r8
            return r8
    }

    public void onDestroy() {
            r2 = this;
            super.onDestroy()
            com.phisher98.donation.DonationManager r0 = com.phisher98.donation.DonationManager.INSTANCE
            r1 = 0
            r0.setDialogShowing(r1)
            return
    }

    public void onDismiss(@org.jetbrains.annotations.NotNull android.content.DialogInterface r3) {
            r2 = this;
            super.onDismiss(r3)
            com.phisher98.donation.DonationManager r0 = com.phisher98.donation.DonationManager.INSTANCE
            r1 = 0
            r0.setDialogShowing(r1)
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r2.onDismissCallback
            if (r0 == 0) goto L10
            r0.invoke()
        L10:
            return
    }

    public void onStart() {
            r8 = this;
            super.onStart()
            android.app.Dialog r0 = r8.getDialog()
            if (r0 == 0) goto L38
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L38
            r1 = 0
            android.content.res.Resources r2 = r8.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            r3 = 1138491392(0x43dc0000, float:440.0)
            float r4 = r2.density
            float r3 = r3 * r4
            int r3 = (int) r3
            int r4 = r2.widthPixels
            double r4 = (double) r4
            r6 = 4606461842859638129(0x3fed70a3d70a3d71, double:0.92)
            double r4 = r4 * r6
            int r4 = (int) r4
            int r5 = java.lang.Math.min(r4, r3)
            r6 = -2
            r0.setLayout(r5, r6)
            r5 = 17
            r0.setGravity(r5)
        L38:
            return
    }
}
