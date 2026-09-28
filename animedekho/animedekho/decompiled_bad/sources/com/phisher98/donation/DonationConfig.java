package com.phisher98.donation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonationData.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b9\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000eHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u000eHÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J³\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0005HÆ\u0001J\u0014\u0010C\u001a\u00020\u00032\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0011\u0010.\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b/\u0010%R\u0011\u00100\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u001a¨\u0006G"}, d2 = {"Lcom/phisher98/donation/DonationConfig;", "", "enabled", "", "extensionName", "", "month", "title", "description", "currency", "targetAmount", "", "currentAmount", "supportersCount", "", "primaryDonateUrl", "primaryButtonText", "secondaryDonateUrl", "secondaryButtonText", "adSupportUrl", "adSupportButtonText", "cooldownHours", "cooldownScope", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getEnabled", "()Z", "getExtensionName", "()Ljava/lang/String;", "getMonth", "getTitle", "getDescription", "getCurrency", "getTargetAmount", "()D", "getCurrentAmount", "getSupportersCount", "()I", "getPrimaryDonateUrl", "getPrimaryButtonText", "getSecondaryDonateUrl", "getSecondaryButtonText", "getAdSupportUrl", "getAdSupportButtonText", "getCooldownHours", "getCooldownScope", "progressPercentage", "getProgressPercentage", "isGoalAchieved", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class DonationConfig {

    @NotNull
    private final String adSupportButtonText;

    @NotNull
    private final String adSupportUrl;
    private final int cooldownHours;

    @NotNull
    private final String cooldownScope;

    @NotNull
    private final String currency;
    private final double currentAmount;

    @NotNull
    private final String description;
    private final boolean enabled;

    @NotNull
    private final String extensionName;

    @NotNull
    private final String month;

    @NotNull
    private final String primaryButtonText;

    @NotNull
    private final String primaryDonateUrl;

    @NotNull
    private final String secondaryButtonText;

    @NotNull
    private final String secondaryDonateUrl;
    private final int supportersCount;
    private final double targetAmount;

    @NotNull
    private final String title;

    public DonationConfig() {
        this(false, null, null, null, null, null, 0.0d, 0.0d, 0, null, null, null, null, null, null, 0, null, 131071, null);
    }

    public static /* synthetic */ DonationConfig copy$default(DonationConfig donationConfig, boolean z, String str, String str2, String str3, String str4, String str5, double d, double d2, int i, String str6, String str7, String str8, String str9, String str10, String str11, int i2, String str12, int i3, Object obj) {
        String str13;
        int i4;
        boolean z2 = (i3 & 1) != 0 ? donationConfig.enabled : z;
        String str14 = (i3 & 2) != 0 ? donationConfig.extensionName : str;
        String str15 = (i3 & 4) != 0 ? donationConfig.month : str2;
        String str16 = (i3 & 8) != 0 ? donationConfig.title : str3;
        String str17 = (i3 & 16) != 0 ? donationConfig.description : str4;
        String str18 = (i3 & 32) != 0 ? donationConfig.currency : str5;
        double d3 = (i3 & 64) != 0 ? donationConfig.targetAmount : d;
        double d4 = (i3 & 128) != 0 ? donationConfig.currentAmount : d2;
        int i5 = (i3 & 256) != 0 ? donationConfig.supportersCount : i;
        String str19 = (i3 & 512) != 0 ? donationConfig.primaryDonateUrl : str6;
        String str20 = (i3 & 1024) != 0 ? donationConfig.primaryButtonText : str7;
        String str21 = (i3 & 2048) != 0 ? donationConfig.secondaryDonateUrl : str8;
        boolean z3 = z2;
        String str22 = (i3 & 4096) != 0 ? donationConfig.secondaryButtonText : str9;
        String str23 = (i3 & 8192) != 0 ? donationConfig.adSupportUrl : str10;
        String str24 = (i3 & 16384) != 0 ? donationConfig.adSupportButtonText : str11;
        int i6 = (i3 & 32768) != 0 ? donationConfig.cooldownHours : i2;
        if ((i3 & 65536) != 0) {
            i4 = i6;
            str13 = donationConfig.cooldownScope;
        } else {
            str13 = str12;
            i4 = i6;
        }
        return donationConfig.copy(z3, str14, str15, str16, str17, str18, d3, d4, i5, str19, str20, str21, str22, str23, str24, i4, str13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPrimaryDonateUrl() {
        return this.primaryDonateUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPrimaryButtonText() {
        return this.primaryButtonText;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getSecondaryDonateUrl() {
        return this.secondaryDonateUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSecondaryButtonText() {
        return this.secondaryButtonText;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getAdSupportUrl() {
        return this.adSupportUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAdSupportButtonText() {
        return this.adSupportButtonText;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getCooldownHours() {
        return this.cooldownHours;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getCooldownScope() {
        return this.cooldownScope;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getExtensionName() {
        return this.extensionName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final double getTargetAmount() {
        return this.targetAmount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final double getCurrentAmount() {
        return this.currentAmount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getSupportersCount() {
        return this.supportersCount;
    }

    @NotNull
    public final DonationConfig copy(boolean enabled, @NotNull String extensionName, @NotNull String month, @NotNull String title, @NotNull String description, @NotNull String currency, double targetAmount, double currentAmount, int supportersCount, @NotNull String primaryDonateUrl, @NotNull String primaryButtonText, @NotNull String secondaryDonateUrl, @NotNull String secondaryButtonText, @NotNull String adSupportUrl, @NotNull String adSupportButtonText, int cooldownHours, @NotNull String cooldownScope) {
        return new DonationConfig(enabled, extensionName, month, title, description, currency, targetAmount, currentAmount, supportersCount, primaryDonateUrl, primaryButtonText, secondaryDonateUrl, secondaryButtonText, adSupportUrl, adSupportButtonText, cooldownHours, cooldownScope);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DonationConfig)) {
            return false;
        }
        DonationConfig donationConfig = (DonationConfig) other;
        return this.enabled == donationConfig.enabled && Intrinsics.areEqual(this.extensionName, donationConfig.extensionName) && Intrinsics.areEqual(this.month, donationConfig.month) && Intrinsics.areEqual(this.title, donationConfig.title) && Intrinsics.areEqual(this.description, donationConfig.description) && Intrinsics.areEqual(this.currency, donationConfig.currency) && Double.compare(this.targetAmount, donationConfig.targetAmount) == 0 && Double.compare(this.currentAmount, donationConfig.currentAmount) == 0 && this.supportersCount == donationConfig.supportersCount && Intrinsics.areEqual(this.primaryDonateUrl, donationConfig.primaryDonateUrl) && Intrinsics.areEqual(this.primaryButtonText, donationConfig.primaryButtonText) && Intrinsics.areEqual(this.secondaryDonateUrl, donationConfig.secondaryDonateUrl) && Intrinsics.areEqual(this.secondaryButtonText, donationConfig.secondaryButtonText) && Intrinsics.areEqual(this.adSupportUrl, donationConfig.adSupportUrl) && Intrinsics.areEqual(this.adSupportButtonText, donationConfig.adSupportButtonText) && this.cooldownHours == donationConfig.cooldownHours && Intrinsics.areEqual(this.cooldownScope, donationConfig.cooldownScope);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((DonationConfig$$ExternalSyntheticBackport0.m(this.enabled) * 31) + this.extensionName.hashCode()) * 31) + this.month.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.currency.hashCode()) * 31) + DonationConfig$$ExternalSyntheticBackport1.m(this.targetAmount)) * 31) + DonationConfig$$ExternalSyntheticBackport1.m(this.currentAmount)) * 31) + this.supportersCount) * 31) + this.primaryDonateUrl.hashCode()) * 31) + this.primaryButtonText.hashCode()) * 31) + this.secondaryDonateUrl.hashCode()) * 31) + this.secondaryButtonText.hashCode()) * 31) + this.adSupportUrl.hashCode()) * 31) + this.adSupportButtonText.hashCode()) * 31) + this.cooldownHours) * 31) + this.cooldownScope.hashCode();
    }

    @NotNull
    public String toString() {
        return "DonationConfig(enabled=" + this.enabled + ", extensionName=" + this.extensionName + ", month=" + this.month + ", title=" + this.title + ", description=" + this.description + ", currency=" + this.currency + ", targetAmount=" + this.targetAmount + ", currentAmount=" + this.currentAmount + ", supportersCount=" + this.supportersCount + ", primaryDonateUrl=" + this.primaryDonateUrl + ", primaryButtonText=" + this.primaryButtonText + ", secondaryDonateUrl=" + this.secondaryDonateUrl + ", secondaryButtonText=" + this.secondaryButtonText + ", adSupportUrl=" + this.adSupportUrl + ", adSupportButtonText=" + this.adSupportButtonText + ", cooldownHours=" + this.cooldownHours + ", cooldownScope=" + this.cooldownScope + ")";
    }

    public DonationConfig(boolean enabled, @NotNull String extensionName, @NotNull String month, @NotNull String title, @NotNull String description, @NotNull String currency, double targetAmount, double currentAmount, int supportersCount, @NotNull String primaryDonateUrl, @NotNull String primaryButtonText, @NotNull String secondaryDonateUrl, @NotNull String secondaryButtonText, @NotNull String adSupportUrl, @NotNull String adSupportButtonText, int cooldownHours, @NotNull String cooldownScope) {
        this.enabled = enabled;
        this.extensionName = extensionName;
        this.month = month;
        this.title = title;
        this.description = description;
        this.currency = currency;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.supportersCount = supportersCount;
        this.primaryDonateUrl = primaryDonateUrl;
        this.primaryButtonText = primaryButtonText;
        this.secondaryDonateUrl = secondaryDonateUrl;
        this.secondaryButtonText = secondaryButtonText;
        this.adSupportUrl = adSupportUrl;
        this.adSupportButtonText = adSupportButtonText;
        this.cooldownHours = cooldownHours;
        this.cooldownScope = cooldownScope;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DonationConfig(boolean z, String str, String str2, String str3, String str4, String str5, double d, double d2, int i, String str6, String str7, String str8, String str9, String str10, String str11, int i2, String str12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z2 = (i3 & 1) != 0 ? true : z;
        String str13 = (i3 & 2) != 0 ? "" : str;
        String str14 = (i3 & 4) != 0 ? "Monthly Goal" : str2;
        String str15 = (i3 & 8) != 0 ? "Help Keep This Extension Alive" : str3;
        String str16 = (i3 & 16) != 0 ? "" : str4;
        String str17 = (i3 & 32) != 0 ? "$" : str5;
        double d3 = (i3 & 64) != 0 ? 100.0d : d;
        double d4 = (i3 & 128) != 0 ? 0.0d : d2;
        int i4 = (i3 & 256) != 0 ? 0 : i;
        String str18 = (i3 & 512) != 0 ? "https://buymeacoffee.com/phisher98" : str6;
        String str19 = (i3 & 1024) != 0 ? "☕ Keep It Alive" : str7;
        String str20 = (i3 & 2048) == 0 ? str8 : "";
        this(z2, str13, str14, str15, str16, str17, d3, d4, i4, str18, str19, str20, (i3 & 4096) != 0 ? "⚡ Donate via UPI / Other" : str9, (i3 & 8192) != 0 ? "https://omg10.com/4/11733824" : str10, (i3 & 16384) != 0 ? "🎬 Can't donate? Watch an Ad to Support ↗" : str11, (i3 & 32768) != 0 ? 24 : i2, (i3 & 65536) != 0 ? "global" : str12);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final String getExtensionName() {
        return this.extensionName;
    }

    @NotNull
    public final String getMonth() {
        return this.month;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getCurrency() {
        return this.currency;
    }

    public final double getTargetAmount() {
        return this.targetAmount;
    }

    public final double getCurrentAmount() {
        return this.currentAmount;
    }

    public final int getSupportersCount() {
        return this.supportersCount;
    }

    @NotNull
    public final String getPrimaryDonateUrl() {
        return this.primaryDonateUrl;
    }

    @NotNull
    public final String getPrimaryButtonText() {
        return this.primaryButtonText;
    }

    @NotNull
    public final String getSecondaryDonateUrl() {
        return this.secondaryDonateUrl;
    }

    @NotNull
    public final String getSecondaryButtonText() {
        return this.secondaryButtonText;
    }

    @NotNull
    public final String getAdSupportUrl() {
        return this.adSupportUrl;
    }

    @NotNull
    public final String getAdSupportButtonText() {
        return this.adSupportButtonText;
    }

    public final int getCooldownHours() {
        return this.cooldownHours;
    }

    @NotNull
    public final String getCooldownScope() {
        return this.cooldownScope;
    }

    public final int getProgressPercentage() {
        if (this.targetAmount > 0.0d) {
            return RangesKt.coerceIn((int) ((this.currentAmount / this.targetAmount) * 100.0d), 0, 100);
        }
        return 0;
    }

    public final boolean isGoalAchieved() {
        return this.targetAmount > 0.0d && this.currentAmount >= this.targetAmount;
    }
}
